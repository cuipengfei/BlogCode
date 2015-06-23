package learnscalaz

object LearnZ {
  def sum[A](xs: List[A])(implicit m: Monoid[A]): A = xs.foldLeft(m.mzero)(m.mappend)

  trait Monoid[A] {
    def mappend(a1: A, a2: A): A

    def mzero: A
  }

  implicit val intMonoid = new Monoid[Int] {
    def mappend(a: Int, b: Int): Int = a + b

    def mzero: Int = 0
  }

  implicit val stringMonoid: Monoid[String] = new Monoid[String] {
    def mappend(a: String, b: String): String = a + b

    def mzero: String = ""
  }

  def main(args: Array[String]) {
    println(sum(List(1, 2, 3, 4)))
    println(sum(List("a", "b", "c")))
  }
}
