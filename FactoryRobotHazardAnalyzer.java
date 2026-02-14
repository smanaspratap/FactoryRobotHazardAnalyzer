import java.util.Scanner;

public class FactoryRobotHazardAnalyzer {


    public static void main(String[] args) {

        System.out.println("Factory Robot Hazard Analyzer");

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Arm Precision (0.0 - 1.0):");
        double armPrecision = sc.nextDouble();

        System.out.println("Enter Worker Density (1 - 20):");
        int workerDensity = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.println("Enter Machinery State (Worn/Faulty/Critical):");
        String machineryState = sc.nextLine();

        try {
            double hazardRisk = calculateHazardRisk(armPrecision, workerDensity, machineryState);
            System.out.println("Robot Hazard Risk Score: " + hazardRisk);
        } catch (RobotSafetyException e) {
            System.out.println(e.getMessage());
        }

        sc.close();
    }

    // UC7: Validation + structured machinery risk mapping
    public static double calculateHazardRisk(double armPrecision,
                                             int workerDensity,
                                             String machineryState)
            throws RobotSafetyException {

        // Validate arm precision
        if (armPrecision < 0.0 || armPrecision > 1.0) {
            throw new RobotSafetyException("Error: Arm precision must be 0.0-1.0");
        }

        // Validate worker density
        if (workerDensity < 1 || workerDensity > 20) {
            throw new RobotSafetyException("Error: Worker density must be 1-20");
        }

        // Map machinery state (CASE-SENSITIVE)
        double machineRiskFactor;

        if ("Worn".equals(machineryState)) {
            machineRiskFactor = 1.3;
        }
        else if ("Faulty".equals(machineryState)) {
            machineRiskFactor = 2.0;
        }
        else if ("Critical".equals(machineryState)) {
            machineRiskFactor = 3.0;
        }
        else {
            throw new RobotSafetyException("Error: Unsupported machinery state");
        }

        // Hazard Risk Formula (from assignment)
        return ((1.0 - armPrecision) * 15.0)
                + (workerDensity * machineRiskFactor);
    }
}
