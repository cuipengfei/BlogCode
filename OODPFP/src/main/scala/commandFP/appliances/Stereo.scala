package commandFP.appliances

case class Stereo(location: String) {
  def on() = println(s"$location stereo is on")

  def off() = println(s"$location stereo is off")
}
