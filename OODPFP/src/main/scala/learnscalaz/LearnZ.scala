package learnscalaz

object LearnZ {
  def sum(xs: List[Int]): Int = xs.foldLeft(0)(_ + _)

  def main(args: Array[String]) {
    sum(List(1, 2, 3, 4))
  }
}
