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

        double hazardRisk = calculateHazardRisk(armPrecision, workerDensity, machineryState);
        // In UC5 the method handles validation by returning Double.NaN on error (we'll replace with exceptions in UC6)
        if (Double.isNaN(hazardRisk)) {
            // calculateHazardRisk already printed error messages in UC5 approach
        } else {
            System.out.println("Robot Hazard Risk Score: " + hazardRisk);
        }

        sc.close();
    }

    // UC5: method encapsulating calculation and validation (no custom exception yet)
    public static double calculateHazardRisk(double armPrecision, int workerDensity, String machineryState) {
        if (armPrecision < 0.0 || armPrecision > 1.0) {
            System.out.println("Error: Arm precision must be 0.0-1.0");
            return Double.NaN;
        }

        if (workerDensity < 1 || workerDensity > 20) {
            System.out.println("Error: Worker density must be 1-20");
            return Double.NaN;
        }

        double machineRiskFactor;
        if ("Worn".equals(machineryState)) {
            machineRiskFactor = 1.3;
        } else if ("Faulty".equals(machineryState)) {
            machineRiskFactor = 2.0;
        } else if ("Critical".equals(machineryState)) {
            machineRiskFactor = 3.0;
        } else {
            System.out.println("Error: Unsupported machinery state");
            return Double.NaN;
        }

        return ((1.0 - armPrecision) * 15.0) + (workerDensity * machineRiskFactor);
    }
}
