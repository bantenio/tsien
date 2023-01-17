package org.tenio.tsien.exceptions;

public class NotSupportExecutionContextTypeException extends TsienException {

    public NotSupportExecutionContextTypeException() {
    }

    public NotSupportExecutionContextTypeException(String message) {
        super(message);
    }

    public NotSupportExecutionContextTypeException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotSupportExecutionContextTypeException(Throwable cause) {
        super(cause);
    }

    public NotSupportExecutionContextTypeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
