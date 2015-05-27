package strategy.ducks;

import strategy.fly.FlyNoWay;
import strategy.quack.MuteQuack;

public class DecoyDuck extends Duck {

    public DecoyDuck() {
        setFlyBehavior(new FlyNoWay());
        setQuackBehavior(new MuteQuack());
    }

}
