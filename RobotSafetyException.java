public class RobotSafetyException extends Exception {
    public RobotSafetyException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        // Ensures the exception object prints the message when printed
        return getMessage();
    }
}
