package commandFP.appliances

case class Hottub(var isOn: Boolean = false) {
  private var temperature: Int = 0

  def on() = isOn = true

  def off() = isOn = false

  def circulate() = if (isOn) println("Hottub is bubbling!")

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
