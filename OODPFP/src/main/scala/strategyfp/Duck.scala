package strategyfp

import strategyfp.Duck.{Fly, Quack, _}

abstract class Duck(f: Fly, q: Quack) {
  def swim() = println("all ducks float")

  def fly() = f()

  def quack() = q()
}

object Duck {
  type Fly = () => Unit
  val realFly = () => println("really flying")
  val canNotFly = () => println("can not fly")

  type Quack = () => Unit
  val realQuack = () => println("really quacking")
  val muteQuack = () => println("<<silence>>")
}

class MallardDuck extends Duck(realFly, realQuack)

class DecoyDuck extends Duck(canNotFly, muteQuack)

object DuckSimFP {
  def main(args: Array[String]) {
    val mallardDuck = new MallardDuck()
    mallardDuck.fly()
    mallardDuck.quack()
  }
}