package commandFP.appliances

case class TV(location: String) {
  private var channel: Int = 0

  def on() = println(location + " TV is on")

  def off() = println(location + " TV is off")

  def setInputChannel() = {
    this.channel = 3
    println(location + " TV channel is set for DVD")
  }
}
