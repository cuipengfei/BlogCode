package strategy

abstract class Duck extends Fly with Quack {
  def swim = println("all ducks float")
}

class MallardDuck extends Duck with FlyWithWings with RealQuack

class DecoyDuck extends Duck with FlyNoWay with MuteQuack

object DuckSim {
  def main(args: Array[String]) = {
    val anonymousDuck = new Duck with FlyWithWings with MuteQuack
    anonymousDuck.fly()
    anonymousDuck.quack()
  }
}