package stateS

trait State {
  def insertQuarter(implicit gumballMachine: GumballMachine): GumballMachine

  def ejectQuarter(implicit gumballMachine: GumballMachine): GumballMachine

  def turnCrank(implicit gumballMachine: GumballMachine): GumballMachine

  def dispense(implicit gumballMachine: GumballMachine): GumballMachine
}

object NoQuarterState extends State {
  override def insertQuarter(implicit gumballMachine: GumballMachine) = {
    println("You inserted a quarter")
    gumballMachine.copy(state = HasQuarterState)
  }

  override def dispense(implicit gumballMachine: GumballMachine) = {
    println("You need to pay first")
    gumballMachine
  }

  override def ejectQuarter(implicit gumballMachine: GumballMachine) = {
    println("You haven't inserted a quarter")
    gumballMachine
  }

  override def turnCrank(implicit gumballMachine: GumballMachine) = {
    println("You turned, but there's no quarter")
    gumballMachine
  }
}

object HasQuarterState extends State {
  override def insertQuarter(implicit gumballMachine: GumballMachine) = {
    println("You can't insert another quarter")
    gumballMachine
  }

  override def dispense(implicit gumballMachine: GumballMachine) = {
    println("No gumball dispensed")
    gumballMachine
  }

  override def ejectQuarter(implicit gumballMachine: GumballMachine) = {
    println("Quarter returned")
    gumballMachine.copy(state = NoQuarterState)
  }

  override def turnCrank(implicit gumballMachine: GumballMachine) = {
    println("You turned...")
    gumballMachine.copy(state = SoldState)
  }
}

object SoldState extends State {
  override def insertQuarter(implicit gumballMachine: GumballMachine) = {
    println("Please wait, we're already giving you a gumball")
    gumballMachine
  }

  override def dispense(implicit gumballMachine: GumballMachine) = {
    val releasedMachine = gumballMachine.releaseBall
    if (releasedMachine.numberGumBalls > 0)
      releasedMachine.copy(state = NoQuarterState)
    else {
      println("Oops, out of gumballs!")
      releasedMachine.copy(state = SoldOutState)
    }
  }

  override def ejectQuarter(implicit gumballMachine: GumballMachine) = {
    println("Sorry, you already turned the crank")
    gumballMachine
  }

  override def turnCrank(implicit gumballMachine: GumballMachine) = {
    println("Turning twice doesn't get you another gumball!")
    gumballMachine
  }
}

object SoldOutState extends State {
  override def insertQuarter(implicit gumballMachine: GumballMachine) = {
    println("You can't insert a quarter, the machine is sold out")
    gumballMachine
  }

  override def dispense(implicit gumballMachine: GumballMachine) = {
    println("No gumball dispensed")
    gumballMachine
  }

  override def ejectQuarter(implicit gumballMachine: GumballMachine) = {
    println("You can't eject, you haven't inserted a quarter yet")
    gumballMachine
  }

  override def turnCrank(implicit gumballMachine: GumballMachine) = {
    println("You turned, but there are no gumballs")
    gumballMachine
  }
}

case class GumballMachine(private val state: State, numberGumBalls: Int) {
  implicit val machine: GumballMachine = this

  def releaseBall = {
    println("A gumball comes rolling out the slot...")
    if (numberGumBalls != 0) this.copy(numberGumBalls = numberGumBalls - 1)
    else this
  }

  def insertQuarter = state.insertQuarter

  def ejectQuarter = state.ejectQuarter

  def turnCrank = state.turnCrank.state.dispense

  def refill(count: Int) = GumballMachine(NoQuarterState, count)
}

object GumballMachineTestDrive {
  def main(args: Array[String]) {
    GumballMachine(NoQuarterState, 2)
      .insertQuarter
      .turnCrank
      .ejectQuarter
      .insertQuarter
      .turnCrank
      .insertQuarter
      .turnCrank
      .refill(1)
      .insertQuarter
      .turnCrank
  }
}