import java.io.File;
import java.io.IOException;

public class Main {
    public static String reportFile = "report_data.txt";

    public static void main(String[] args) throws IOException {
        String folderPath = "./test";
        File folder = new File(folderPath);
        if (folder.exists() && folder.isDirectory()) {
            String[] files = folder.list();
            if (files != null) {
                for (String filename : files) {
                    System.out.println("Now Processing inputs from file: " + filename);
                    TSPSolver tspSolver = new TSPSolver(new File(folder, filename));
                    tspSolver.processTSP();
                    System.out.println("Ended processing inputs from file: " + filename);
                }

            } else {
                System.out.println("This folder is empty");
            }
        } else {
            System.out.println("No such directory exits here");
        }
        System.out.println("Process finished successfully");
    }
}
