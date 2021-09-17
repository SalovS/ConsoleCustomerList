public class ConsoleException extends Exception{
    public ConsoleException() {
    }

    public ConsoleException(String message) {
        super(message);
        System.err.println(message);
    }

    public ConsoleException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConsoleException(Throwable cause) {
        super(cause);
    }

    public ConsoleException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
