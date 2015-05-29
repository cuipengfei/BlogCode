package chainofresponsibility;

/**
 * Created by pfcui on 5/29/15.
 */
class EmailLogger extends Logger {
    public EmailLogger(int mask) {
        super(mask);
    }

    protected void writeMessage(String msg) {
        System.out.println("Sending via e-mail: " + msg);
    }
}
