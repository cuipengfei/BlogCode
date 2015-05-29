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

        // Handled by StdoutLogger (level = 7)
        chain.message("Entering function y.", Logger.DEBUG);

        // Handled by StdoutLogger and EmailLogger (level = 5)
        chain.message("Step1 completed.", Logger.NOTICE);

        // Handled by all three loggers (level = 3)
        chain.message("An error has occurred.", Logger.ERR);
    }
}
