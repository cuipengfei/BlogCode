package learnscalaz

object LearnZ {
  def sum(xs: List[Int]): Int = xs.foldLeft(IntMonoid.mzero)(IntMonoid.mappend)

  object IntMonoid {
    def mappend(a: Int, b: Int): Int = a + b

    def mzero: Int = 0
  }

  def main(args: Array[String]) {
    sum(List(1, 2, 3, 4))
  }
}
