package mementoS

case class Originator(state: String) {

  case class Memento(state: String)

  def save = Memento(state)

  def restore(memento: Memento) = Originator(memento.state)
}

object Caretake {
  def main(args: Array[String]) {
    val originator = Originator("state1")
    val save = originator.save
    originator.restore(save)
  }
}