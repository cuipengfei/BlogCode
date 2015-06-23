package learnscalaz

object LearnZ {
  def sum(xs: List[Int], m: Monoid[Int]): Int = xs.foldLeft(m.mzero)(m.mappend)

  trait Monoid[A] {
    def mappend(a1: A, a2: A): A

    def mzero: A
  }

  val intMonoid = new Monoid[Int] {
    def mappend(a: Int, b: Int): Int = a + b

    def mzero: Int = 0
  }

  def main(args: Array[String]) {
    println(sum(List(1, 2, 3, 4), intMonoid))
  }
}
