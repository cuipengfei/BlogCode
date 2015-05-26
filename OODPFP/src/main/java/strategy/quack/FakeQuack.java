package strategy.quack;

import strategy.quack.QuackBehavior;

public class FakeQuack implements QuackBehavior {
    public void quack() {
        System.out.println("Qwak");
    }
}
