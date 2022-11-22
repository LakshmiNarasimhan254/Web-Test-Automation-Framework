package org.mln.customexceptions;

/**
 * This class is a custom exception class that extends the CustomException class
 */
public class BrowserInvocationFailedException extends CustomException{

    public BrowserInvocationFailedException(String message) {
        super(message);
    }

    public BrowserInvocationFailedException(String message, Throwable cause) {
        super(message, cause);
    }
    public BrowserInvocationFailedException(Throwable cause) {
        super("Browser could not be invocated.Please check browser capabilities.");
    }
}
