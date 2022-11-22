package org.mln.customexceptions;

/**
 * CustomException is a RuntimeException that can be thrown when a custom exception is needed
 */
/**
 * CustomException is a RuntimeException that can be thrown when a custom exception is needed
 */
public class CustomException extends RuntimeException{
    public CustomException(String message){
        super(message);
    }
    public CustomException(String message,Throwable cause){
        super(message,cause);
    }
}
