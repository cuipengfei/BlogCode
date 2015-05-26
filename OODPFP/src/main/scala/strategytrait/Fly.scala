package strategytrait

trait Fly {
  def fly()
}

trait FlyWithWings extends Fly {
  def fly() = println("fly with wings")
}

trait FlyNoWay extends Fly {
  def fly() = println("can not fly")
}