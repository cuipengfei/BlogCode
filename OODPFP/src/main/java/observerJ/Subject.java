package observerJ;

public interface Subject {
    void registerObserver(Observer o);

    void notifyObservers();
}
