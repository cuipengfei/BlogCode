package strategy

trait Quack {
  def quack()
}

trait RealQuack {
  def quack() = println("Quak")
}

trait MuteQuack {
  def quack() = println("<<silence>>")
}