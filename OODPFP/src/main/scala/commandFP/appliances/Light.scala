package commandFP.appliances

case class Light(location: String) {
  def on() = println(s"$location light is on")

  def off() = println(s"$location light is off")
}
