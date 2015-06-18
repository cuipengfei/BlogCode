package mementoJ;

import static java.lang.System.out;

class Originator {
    private String state;

    public void set(String state) {
        out.println("Originator: Setting state to " + state);
        this.state = state;
    }

    public Memento saveToMemento() {
        out.println("Originator: Saving to Memento.");
        return new Memento(this.state);
    }

    public void restoreFromMemento(Memento memento) {
        this.state = memento.getSavedState();
        out.println("Originator: State after restoring from Memento: " + state);
    }

    public static class Memento {
        private final String state;

        public Memento(String stateToSave) {
            state = stateToSave;
        }

        public String getSavedState() {
            return state;
        }
    }
}
