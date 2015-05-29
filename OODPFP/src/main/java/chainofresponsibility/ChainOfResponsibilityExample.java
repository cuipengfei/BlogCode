package chainofresponsibility;

public class ChainOfResponsibilityExample {

    private static Logger createChain() {
        return Logger.chain(
                new StdoutLogger(Logger.DEBUG),
                new EmailLogger(Logger.NOTICE),
                new StderrLogger(Logger.ERR));
    }

    public static void main(String[] args) {
        Logger chain = createChain();
        chain.message("Entering function y.", Logger.DEBUG);
        chain.message("Step1 completed.", Logger.NOTICE);
        chain.message("An error has occurred.", Logger.ERR);
    }
}
