package strategy;

import strategy.ducks.DecoyDuck;
import strategy.ducks.MallardDuck;
import strategy.ducks.ModelDuck;
import strategy.ducks.RubberDuck;
import strategy.fly.FlyRocketPowered;

public class MiniDuckSimulator {

    public static void main(String[] args) {

        MallardDuck mallard = new MallardDuck();
        RubberDuck rubberDuckie = new RubberDuck();
        DecoyDuck decoy = new DecoyDuck();

        ModelDuck model = new ModelDuck();

        mallard.performQuack();
        rubberDuckie.performQuack();
        decoy.performQuack();

        model.performFly();
        model.setFlyBehavior(new FlyRocketPowered());
        model.performFly();
    }
}
