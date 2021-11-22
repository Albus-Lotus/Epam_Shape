package com.edu.kravchenko.shape.exception;

public class EllipseException extends Exception {

    public EllipseException() {
    }

    public EllipseException(String message) {
        super(message);
    }

    public EllipseException(String message, Throwable cause) {
        super(message, cause);
    }

    public EllipseException(Throwable cause) {
        super(cause);
    }
}
