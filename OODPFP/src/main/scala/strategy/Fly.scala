package strategy

trait Fly {
  def fly()
}

trait FlyWithWings extends Fly {
  def fly() = println("flying with wings")
}

trait FlyNoWay extends Fly {
  def fly() = println("can not fly")
}