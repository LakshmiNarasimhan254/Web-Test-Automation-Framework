package org.mln.customexceptions;

public class  PropertyFileUsageException extends CustomException{
    public PropertyFileUsageException(String message) {
        super(message);
    }

    public PropertyFileUsageException(String message, Throwable cause) {
        super(message, cause);
    }
}
