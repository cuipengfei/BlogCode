package commandFP.appliances

case class Hottub(var on: Boolean = false) {
  private var temperature: Int = 0

  def turnOn() = on = true

  def off() = on = false

  def circulate() = if (on) println("Hottub is bubbling!")

  def setTemperature(temperature: Int) = {
    if (temperature > this.temperature) {
      println("Hottub is heating to a steaming " + temperature + " degrees")
    }
    else {
      println("Hottub is cooling to " + temperature + " degrees")
    }
    this.temperature = temperature
  }
}
