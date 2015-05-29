package chainofresponsibilityfp

object Chain {
  val ERR = 3
  val NOTICE = 5
  val DEBUG = 7

  type Logger = LogEvent => LogEvent

  case class LogEvent(message: String, priority: Int) {
    def doIfMatch(expectedPriority: Int, f: => Unit) = {
      if (priority <= expectedPriority) f
      this
    }
  }

  val stdOutLogger: Logger = (event) =>
    event.doIfMatch(DEBUG, println(s"Writing to stdout: ${event.message}"))

  val emailLogger: Logger = (event) =>
    event.doIfMatch(NOTICE, println(s"Sending via e-mail: ${event.message}"))

  val stdErrLogger: Logger = (event) =>
    event.doIfMatch(ERR, println(s"Sending to stderr: ${event.message}"))

  def main(args: Array[String]) {
    val chainedLoggers = stdOutLogger.andThen(emailLogger).andThen(stdErrLogger)

    chainedLoggers(LogEvent("Entering function y.", DEBUG))
    chainedLoggers(LogEvent("Step1 completed.", NOTICE))
    chainedLoggers(LogEvent("An error has occurred.", ERR))
  }
}
