package com.team.geaStargram.exception;

public class NotMacthedValueException extends RuntimeException {
    public NotMacthedValueException() {
        super();
    }

    public NotMacthedValueException(String message) {
        super(message);
    }

    public NotMacthedValueException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotMacthedValueException(Throwable cause) {
        super(cause);
    }

    protected NotMacthedValueException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
