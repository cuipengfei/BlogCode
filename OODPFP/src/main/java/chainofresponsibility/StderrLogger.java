package chainofresponsibility;

class StderrLogger extends Logger {
    public StderrLogger(int mask) {
        super(mask);
    }

    protected void writeMessage(String msg) {
        System.err.println("Sending to stderr: " + msg);
    }
}

/*
The output is:
   Writing to stdout:   Entering function y.
   Writing to stdout:   Step1 completed.
   Sending via e-mail:  Step1 completed.
   Writing to stdout:   An error has occurred.
   Sending via e-mail:  An error has occurred.
   Sending to stderr:   An error has occurred.
*/
