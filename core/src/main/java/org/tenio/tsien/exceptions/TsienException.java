package org.tenio.tsien.exceptions;

public class TsienException extends RuntimeException {

    public TsienException() {
    }

    public TsienException(String message) {
        super(message);
    }

    public TsienException(String message, Throwable cause) {
        super(message, cause);
    }

    public TsienException(Throwable cause) {
        super(cause);
    }

    public TsienException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
