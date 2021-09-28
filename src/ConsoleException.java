public class ConsoleException extends Exception{
    public ConsoleException(String message) {
        super(message);
        System.err.println(message);
    }
}
