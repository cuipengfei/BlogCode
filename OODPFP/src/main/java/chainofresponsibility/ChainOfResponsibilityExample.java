package chainofresponsibility;

public class ChainOfResponsibilityExample {

    private static Logger createChain() {
        Logger logger = new StdoutLogger(Logger.DEBUG);

        Logger logger1 = new EmailLogger(Logger.NOTICE);
        logger.setNext(logger1);

        Logger logger2 = new StderrLogger(Logger.ERR);
        logger1.setNext(logger2);

        return logger;
    }

    public static void main(String[] args) {
        Logger chain = createChain();
        chain.message("Entering function y.", Logger.DEBUG);
        chain.message("Step1 completed.", Logger.NOTICE);
        chain.message("An error has occurred.", Logger.ERR);
    }
}
