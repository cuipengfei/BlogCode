package command.runner;

import command.Command;
import command.MacroCommand;
import command.appliances.Hottub;
import command.appliances.Light;
import command.appliances.Stereo;
import command.appliances.TV;
import command.commands.*;

public class RemoteLoader {

    public static void main(String[] args) {

        RemoteControl remoteControl = new RemoteControl();

        Light light = new Light("Living Room");
        TV tv = new TV("Living Room");
        Stereo stereo = new Stereo("Living Room");
        Hottub hottub = new Hottub();

        Command[] partyOn = {
                new LightOnCommand(light), new StereoOnCommand(stereo),
                new TVOnCommand(tv), new HottubOnCommand(hottub)};

        Command[] partyOff = {new LightOffCommand(light), new StereoOffCommand(stereo),
                new TVOffCommand(tv), new HottubOffCommand(hottub)};

        remoteControl.setCommand(0, new MacroCommand(partyOn), new MacroCommand(partyOff));

        System.out.println(remoteControl);
        System.out.println("--- Pushing Macro On---");
        remoteControl.onButtonWasPushed(0);
        System.out.println("--- Pushing Macro Off---");
        remoteControl.offButtonWasPushed(0);
    }
}
