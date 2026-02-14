public class RobotSafetyException extends Exception {
    public RobotSafetyException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return getMessage();
    }
}
