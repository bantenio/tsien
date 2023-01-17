package org.tenio.tsien.exceptions;

public class NotSupportNodeTypeException extends TsienException {
    public NotSupportNodeTypeException() {
    }

    public NotSupportNodeTypeException(String message) {
        super(message);
    }

    public NotSupportNodeTypeException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotSupportNodeTypeException(Throwable cause) {
        super(cause);
    }

    public NotSupportNodeTypeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
