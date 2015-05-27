package strategyj8;

import static strategyj8.BehaviorsRepo.flyWithWings;
import static strategyj8.BehaviorsRepo.realQuack;

public class MallardDuck extends Duck {
    public MallardDuck() {
        super(flyWithWings, realQuack);
    }
}

