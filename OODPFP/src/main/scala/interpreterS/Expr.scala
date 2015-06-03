package interpreterS

trait Expr

case class Plus(left: Expr, right: Expr) extends Expr

case class Minus(left: Expr, right: Expr) extends Expr

case class Number(n: Int) extends Expr

case class Var(name: String) extends Expr

object ExprEval {
  def eval(expr: Expr, context: Map[String, Expr]): Int = {
    expr match {
      case Plus(l, r) => eval(l, context) + eval(r, context)
      case Minus(l, r) => eval(l, context) - eval(r, context)
      case Number(n) => n
      case Var(name) => eval(context(name), context)
    }
  }

  def main(args: Array[String]) {
    val context = Map("w" -> Number(5), "x" -> Number(10), "z" -> Number(42))
    val expr = Plus(Var("w"), Minus(Var("x"), Var("z")))
    println(eval(expr, context))
  }
}