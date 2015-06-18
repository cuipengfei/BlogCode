package mementoJ;

import java.util.ArrayList;
import java.util.List;

class Caretaker {
    public static void main(String[] args) {
        List<Originator.Memento> savedStates = new ArrayList<>();

        Originator originator = new Originator();
        originator.set("State1");
        originator.set("State2");
        savedStates.add(originator.saveToMemento());

        originator.set("State3");
        savedStates.add(originator.saveToMemento());

        originator.set("State4");
        originator.restoreFromMemento(savedStates.get(1));
    }
}
