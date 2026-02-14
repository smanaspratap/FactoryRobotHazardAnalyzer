public class RobotHazardAuditor {

    // Public API used by main()
    public double calculateHazardRisk(double armPrecision, int workerDensity, String machineryState) throws RobotSafetyException {
        validateInputs(armPrecision, workerDensity);
        double machineRiskFactor = mapMachineryStateToRisk(machineryState);
        return ((1.0 - armPrecision) * 15.0) + (workerDensity * machineRiskFactor);
    }

    private void validateInputs(double armPrecision, int workerDensity) throws RobotSafetyException {
        if (armPrecision < 0.0 || armPrecision > 1.0) {
            throw new RobotSafetyException("Error: Arm precision must be 0.0-1.0");
        }
        if (workerDensity < 1 || workerDensity > 20) {
            throw new RobotSafetyException("Error: Worker density must be 1-20");
        }
    }

    private double mapMachineryStateToRisk(String machineryState) throws RobotSafetyException {
        if ("Worn".equals(machineryState)) return 1.3;
        if ("Faulty".equals(machineryState)) return 2.0;
        if ("Critical".equals(machineryState)) return 3.0;
        throw new RobotSafetyException("Error: Unsupported machinery state");
    }
}
