package org.tenio.tsien.exceptions;

public class NotSupportNullException extends TsienException {
    public NotSupportNullException() {
    }

    public NotSupportNullException(String message) {
        super(message);
    }

    public NotSupportNullException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotSupportNullException(Throwable cause) {
        super(cause);
    }

    public NotSupportNullException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
