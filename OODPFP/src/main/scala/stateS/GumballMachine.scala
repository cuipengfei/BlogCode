package stateS

trait State {
  def insertQuarter(gumballMachine: GumballMachine): GumballMachine

  def ejectQuarter(gumballMachine: GumballMachine): GumballMachine

  def turnCrank(gumballMachine: GumballMachine): GumballMachine

  def dispense(gumballMachine: GumballMachine): GumballMachine
}

case object NoQuarterState extends State {
  override def insertQuarter(gumballMachine: GumballMachine) = {
    println("You inserted a quarter")
    gumballMachine.copy(state = HasQuarterState)
  }

  override def dispense(gumballMachine: GumballMachine) = {
    println("You need to pay first")
    gumballMachine
  }

  override def ejectQuarter(gumballMachine: GumballMachine) = {
    println("You haven't inserted a quarter")
    gumballMachine
  }

  override def turnCrank(gumballMachine: GumballMachine) = {
    println("You turned, but there's no quarter")
    gumballMachine
  }
}

case object HasQuarterState extends State {
  override def insertQuarter(gumballMachine: GumballMachine) = {
    println("You can't insert another quarter")
    gumballMachine
  }

  override def dispense(gumballMachine: GumballMachine) = {
    println("No gumball dispensed")
    gumballMachine
  }

  override def ejectQuarter(gumballMachine: GumballMachine) = {
    println("Quarter returned")
    gumballMachine.copy(state = NoQuarterState)
  }

  override def turnCrank(gumballMachine: GumballMachine) = {
    println("You turned...")
    gumballMachine.copy(state = SoldState)
  }
}

case object SoldState extends State {
  override def insertQuarter(gumballMachine: GumballMachine) = {
    println("Please wait, we're already giving you a gumball")
    gumballMachine
  }

  override def dispense(gumballMachine: GumballMachine) = {
    val releasedMachine = gumballMachine.releaseBall
    if (releasedMachine.numberGumBalls > 0)
      releasedMachine.copy(state = NoQuarterState)
    else {
      println("Oops, out of gumballs!")
      releasedMachine.copy(state = SoldOutState)
    }
  }

  override def ejectQuarter(gumballMachine: GumballMachine) = {
    println("Sorry, you already turned the crank")
    gumballMachine
  }

  override def turnCrank(gumballMachine: GumballMachine) = {
    println("Turning twice doesn't get you another gumball!")
    gumballMachine
  }
}

case object SoldOutState extends State {
  override def insertQuarter(gumballMachine: GumballMachine) = {
    println("You can't insert a quarter, the machine is sold out")
    gumballMachine
  }

  override def dispense(gumballMachine: GumballMachine) = {
    println("No gumball dispensed")
    gumballMachine
  }

  override def ejectQuarter(gumballMachine: GumballMachine) = {
    println("You can't eject, you haven't inserted a quarter yet")
    gumballMachine
  }

  override def turnCrank(gumballMachine: GumballMachine) = {
    println("You turned, but there are no gumballs")
    gumballMachine
  }
}

case class GumballMachine(state: State, numberGumBalls: Int) {
  def releaseBall = {
    println("A gumball comes rolling out the slot...")
    if (numberGumBalls != 0) this.copy(numberGumBalls = numberGumBalls - 1)
    else this
  }

  def insertQuarter = state.insertQuarter(this)

  def ejectQuarter = state.ejectQuarter(this)

  def turnCrank = state.turnCrank(this).state.dispense(this)

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