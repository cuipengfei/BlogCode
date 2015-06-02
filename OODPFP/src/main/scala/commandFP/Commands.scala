package commandFP

import commandFP.appliances.{Hottub, TV}

object Commands {
  type Command = () => Unit

  def tvOn(tv: TV): Command = () => {
    tv.on()
    tv.setInputChannel()
  }

  def hottubOn(hottub: Hottub): Command = () => {
    hottub.on()
    hottub.setTemperature(104)
    hottub.circulate()
  }

  def hottubOff(hottub: Hottub): Command = () => {
    hottub.setTemperature(98)
    hottub.off()
  }

  def macroCommand(commands: Command*): Command = () =>
    commands.foreach(command => command())
}
