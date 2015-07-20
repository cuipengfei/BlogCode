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

class Duck(f: Fly, q: Quack) {
  def swim() = println("all ducks float")

  def fly() = f()

  def quack() = q()
}

object DuckSimFP {
  def main(args: Array[String]) {
    val ducks = Seq(new Duck(flyWithWings, realQuack), new Duck(flyNoWay, muteQuack))

    ducks.foreach(duck => {
      duck.fly()
      duck.quack()
    })
  }
}