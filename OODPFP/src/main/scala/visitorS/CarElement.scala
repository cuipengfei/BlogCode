package visitorS

import visitorS.Visitors._

trait CarElement {
  def accept(visitor: Visitor) = visitor(this)
}

case class Body() extends CarElement

case class Engine() extends CarElement

case class Wheel(name: String) extends CarElement

case class Car() extends CarElement {
  val elements: Seq[CarElement] = Seq(
    Wheel("front left"), Wheel("front right"),
    Wheel("back left"), Wheel("back right"),
    Body(), Engine())

  override def accept(visitor: Visitor) = {
    elements.foreach(_.accept(visitor))
    visitor(this)
  }
}

object Visitors {
  type Visitor = CarElement => Unit

  val printVisitor: Visitor = {
    case Wheel(name) => println(s"Visiting $name wheel")
    case Body() => println("Visiting Body")
    case Engine() => println("Visiting Engine")
    case Car() => println("Visiting Car")
  }

  val doVisitor: Visitor = {
    case Wheel(name) => println(s"Kicking my $name wheel")
    case Body() => println("Moving my body")
    case Engine() => println("Starting my engine")
    case Car() => println("Starting my car")
  }
}

object VisitorDemo {
  def main(args: Array[String]) {
    val car = Car()
    car.accept(printVisitor)
    car.accept(doVisitor)
  }
}