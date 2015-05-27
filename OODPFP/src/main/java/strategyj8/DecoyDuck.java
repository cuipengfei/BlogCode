package strategyj8;

import static strategyj8.BehaviorsRepo.canNotFly;
import static strategyj8.BehaviorsRepo.muteQuack;

public class DecoyDuck extends Duck {
    public DecoyDuck() {
        super(canNotFly, muteQuack);
    }
}
