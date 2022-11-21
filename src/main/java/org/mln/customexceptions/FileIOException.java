package org.mln.customexceptions;

public class FileIOException extends CustomException{
    public FileIOException(String path ,String message) {
        super(message + " :" + path);
    }

    public FileIOException(String path,String message, Throwable cause) {
        super(message + " :" + path, cause);
    }
    public FileIOException(String path) {
        super("File IO Exception occurred in" + " :" + path +".Please check.");
    }
}
