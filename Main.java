import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static String reportFile = "report_data.csv";
    public static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        String folderPath = "./benchmark_data";
        File folder = new File(folderPath);
        bw = new BufferedWriter(new FileWriter(reportFile));
        bw.write("File, Total value, Nearest Neighbour,node swap, node shift , two-opt, Cheapest insertion, node swap, node shift, two-opt, Farthest insertion, node swap, node shift, two-opt\n");

        if (folder.exists() && folder.isDirectory()) {
            String[] files = folder.list();
            if (files != null) {
                for (String filename : files) {
                    System.out.println("Now Processing inputs from file: " + filename);
                    bw.write(filename + ", ");
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
        bw.close();
        System.out.println("Process finished successfully");
    }
}
