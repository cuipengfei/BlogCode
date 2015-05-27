package strategyj8;

public class BehaviorsRepo {
    public static Fly flyWithWings = () -> System.out.println("fly with wings");
    public static Fly canNotFly = () -> System.out.println("can not fly");

    public static Quack realQuack = () -> System.out.println("Quack");
    public static Quack muteQuack = () -> System.out.println("<<silence>>");
}
