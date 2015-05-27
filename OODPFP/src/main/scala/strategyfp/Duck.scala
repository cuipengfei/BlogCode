package strategyfp

import strategyfp.Duck.{Fly, Quack, _}

object Duck {
  type Fly = () => Unit
  val flyWithWings = () => println("fly with wings")
  val flyNoWay = () => println("can not fly")

  type Quack = () => Unit
  val realQuack = () => println("Quack")
  val muteQuack = () => println("<<silence>>")
}

abstract class Duck(f: Fly, q: Quack) {
  def swim() = println("all ducks float")

  def fly() = f()

  def quack() = q()
}

class MallardDuck extends Duck(flyWithWings, realQuack)

class DecoyDuck extends Duck(flyNoWay, muteQuack)

object DuckSimFP {
  def main(args: Array[String]) {
    val mallardDuck = new MallardDuck()
    mallardDuck.fly()
    mallardDuck.quack()
  }
}