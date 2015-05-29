package chainofresponsibility;

abstract class Logger {
    public static int ERR = 3;
    public static int NOTICE = 5;
    public static int DEBUG = 7;

    private int mask;

    private Logger next;

    public Logger(int mask) {
        this.mask = mask;
    }

    public void setNext(Logger logger) {
        next = logger;
    }

    public void message(String msg, int priority) {
        if (priority <= mask) {
            writeMessage(msg);
        }
        if (next != null) {
            next.message(msg, priority);
        }
    }

    abstract protected void writeMessage(String msg);

    public static Logger chain(Logger... loggers) {
        Logger prev = loggers[0];
        for (Logger logger : loggers) {
            if (logger != prev) {
                prev.setNext(logger);
                prev = logger;
            }
        }
        return loggers[0];
    }
}
