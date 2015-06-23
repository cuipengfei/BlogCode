package learnscalaz

object LearnZ {

  trait FoldLeft[F[_]] {
    def foldLeft[A, B](xs: F[A], b: B, f: (B, A) => B): B
  }

  implicit val foldLeftList = new FoldLeft[List] {
    def foldLeft[A, B](xs: List[A], b: B, f: (B, A) => B) = xs.foldLeft(b)(f)
  }

  def sum[M[_], A](xs: M[A])(implicit fl: FoldLeft[M], m: Monoid[A]): A = {
    fl.foldLeft(xs, m.mzero, m.mappend)
  }

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
