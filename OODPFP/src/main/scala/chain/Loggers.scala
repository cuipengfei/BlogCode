package chain

object Loggers {
  val ERR = 3
  val NOTICE = 5
  val DEBUG = 7

  case class Event(message: String, priority: Int)

  type Logger = Event => Event

  val stdOutLogger: Logger = event => handleEvent(event, DEBUG) {
    println(s"Writing to stdout: ${event.message}")
  }

  val emailLogger: Logger = event => handleEvent(event, NOTICE) {
    println(s"Sending via e-mail: ${event.message}")
  }

  val stdErrLogger: Logger = event => handleEvent(event, ERR) {
    println(s"Sending to stderr: ${event.message}")
  }

  private def handleEvent(event: Event, expectedPriority: Int)(handler: => Unit) = {
    if (event.priority <= expectedPriority) handler
    event
  }
}

object ChainRunner {

  import chain.Loggers._

  def main(args: Array[String]) {
    val chain = stdOutLogger
      .andThen(emailLogger)
      .andThen(stdErrLogger)

    chain(Event("Entering function y.", DEBUG))
    chain(Event("Step1 completed.", NOTICE))
    chain(Event("An error has occurred.", ERR))
  }
}