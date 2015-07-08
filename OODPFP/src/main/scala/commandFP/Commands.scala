package commandFP

import commandFP.appliances.{Hottub, TV}

object Commands {
  type Command = () => Unit

  def tvOn(tv: TV)() = {
    tv.on()
    tv.setInputChannel()
  }

  def hottubOn(hottub: Hottub)() = {
    hottub.on()
    hottub.setTemperature(104)
    hottub.circulate()
  }

  def hottubOff(hottub: Hottub)() = {
    hottub.setTemperature(98)
    hottub.off()
  }

  def macroCommand(commands: Command*)() =
    commands.foreach(_())
}
