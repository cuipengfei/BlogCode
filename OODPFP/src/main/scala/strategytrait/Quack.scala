package strategytrait

trait Quack {
  def quack()
}

trait RealQuack {
  def quack() = println("Quack")
}

trait MuteQuack {
  def quack() = println("<<silence>>")
}