public class RobotSafetyException extends Exception {

    public RobotSafetyException(String message) {
        super(message);
    }

    // Ensures only the message is printed
    @Override
    public String toString() {
        return getMessage();
    }
}
