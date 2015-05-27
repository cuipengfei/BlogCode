package strategyj8;

public class Duck {
    private final Fly f;
    private final Quack q;

    public Duck(Fly f, Quack q) {
        this.f = f;
        this.q = q;
    }

    public void fly() {
        f.fly();
    }

    public void quack() {
        q.quack();
    }
}

