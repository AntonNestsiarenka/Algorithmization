package Utils.Exceptions;

public final class OverflowIntException extends Exception {
    public OverflowIntException() {
    }

    public OverflowIntException(String message) {
        super(message);
    }

    public OverflowIntException(String message, Throwable cause) {
        super(message, cause);
    }

    public OverflowIntException(Throwable cause) {
        super(cause);
    }

    public OverflowIntException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
