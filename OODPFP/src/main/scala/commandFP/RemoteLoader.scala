package commandFP

import commandFP.Commands._
import commandFP.appliances.{Hottub, Light, Stereo, TV}

object RemoteLoader {
  def main(args: Array[String]) {
    val light = Light("living room")
    val tv = TV("living room")
    val stereo = Stereo("living room")
    val hottub = Hottub()

    val on = macroCommand(Seq(lightOn(light), tvOn(tv),
      hottubOn(hottub), stereoOn(stereo)))

    val off = macroCommand(Seq(lightOff(light), tvOff(tv),
      hottubOff(hottub), stereoOff(stereo)))

    val remoteControl = RemoteControl(Seq(on), Seq(off))

    println("--- Pushing Macro On---")
    remoteControl.pushOnButton(0)
    println("--- Pushing Macro Off---")
    remoteControl.pushOffButton(0)
  }
}
