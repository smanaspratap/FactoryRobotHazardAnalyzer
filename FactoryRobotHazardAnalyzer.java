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

        // --- UC4: validation using if/else (print errors) ---
        if (armPrecision < 0.0 || armPrecision > 1.0) {
            System.out.println("Error: Arm precision must be 0.0-1.0");
            sc.close();
            return;
        }

        if (workerDensity < 1 || workerDensity > 20) {
            System.out.println("Error: Worker density must be 1-20");
            sc.close();
            return;
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
            sc.close();
            return;
        }

        double hazardRisk = ((1.0 - armPrecision) * 15.0) + (workerDensity * machineRiskFactor);
        System.out.println("Robot Hazard Risk Score: " + hazardRisk);

        sc.close();
    }
}
