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

        // --- No validation here (UC3) ---
        double machineRiskFactor = 0.0;
        if ("Worn".equals(machineryState)) {
            machineRiskFactor = 1.3;
        } else if ("Faulty".equals(machineryState)) {
            machineRiskFactor = 2.0;
        } else if ("Critical".equals(machineryState)) {
            machineRiskFactor = 3.0;
        } // assume valid for UC3

        double hazardRisk = ((1.0 - armPrecision) * 15.0) + (workerDensity * machineRiskFactor);
        System.out.println("Robot Hazard Risk Score: " + hazardRisk);

        sc.close();
    }
}
