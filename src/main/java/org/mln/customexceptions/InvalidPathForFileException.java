package org.mln.customexceptions;

public class InvalidPathForFileException extends CustomException{
    public InvalidPathForFileException(String path ,String message) {
        super(message + " :" + path);
    }

    public InvalidPathForFileException(String path,String message, Throwable cause) {
        super(message + " :" + path, cause);
    }
    public InvalidPathForFileException(String path) {
        super("File Not Found in" + " :" + path +".Please check the path.");
    }
}
