package chain

object Loggers {
  val ERR = 3
  val NOTICE = 5
  val DEBUG = 7

  case class Event(message: String, priority: Int)

  def stdOutLogger(mask: Int)(event: Event) = handleEvent(event, mask) {
    println(s"Writing to stdout: ${event.message}")
  }

  def emailLogger(mask: Int)(event: Event) = handleEvent(event, mask) {
    println(s"Sending via e-mail: ${event.message}")
  }

  def stdErrLogger(mask: Int)(event: Event) = handleEvent(event, mask) {
    System.err.println(s"Sending to stderr: ${event.message}")
  }

  private def handleEvent(event: Event, mask: Int)(handler: => Unit) = {
    if (event.priority <= mask) handler
    event
  }
}

object ChainRunner {

  import chain.Loggers._

  def main(args: Array[String]) {
    val chain = stdOutLogger(DEBUG) andThen emailLogger(NOTICE) andThen stdErrLogger(ERR)

    chain(Event("Entering function y.", DEBUG))
    chain(Event("Step1 completed.", NOTICE))
    chain(Event("An error has occurred.", ERR))
  }
}