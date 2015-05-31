package commandFP

import commandFP.appliances.{Hottub, Light, Stereo, TV}

object Commands {
  type Command = () => Unit

  def lightOn(light: Light): Command = () => light.on()

  def lightOff(light: Light): Command = () => light.off()

  def tvOn(tv: TV): Command = () => {
    tv.on()
    tv.setInputChannel()
  }

  def tvOff(tv: TV): Command = () => tv.off()

  def stereoOn(stereo: Stereo): Command = () => stereo.on()

  def stereoOff(stereo: Stereo): Command = () => stereo.off()

  def hottubOn(hottub: Hottub): Command = () => {
    hottub.on()
    hottub.setTemperature(104)
    hottub.circulate()
  }

  def hottubOff(hottub: Hottub): Command = () => {
    hottub.setTemperature(98)
    hottub.off()
  }

  def macroCommand(commands: Seq[Command]): Command = () =>
    commands.foreach(command => command())
}
