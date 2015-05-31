package commandFP

import commandFP.Commands.Command

case class RemoteControl(onCommands: Seq[Command], offCommands: Seq[Command]) {
  def pushOnButton(slot: Int) = onCommands(slot)()

  def pushOffButton(slot: Int) = offCommands(slot)()
}
