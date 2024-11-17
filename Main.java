import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static String reportFile = "report_data.csv";
    public static String percentageReportForNearestNeightbour = "report_percentage_nearest_neighbour.csv";
    public static String percentageReportForCheapestInsertion = "report_percentage_cheapest_insertion.csv";
    public static String percentageReportForFarthestInsertion = "report_percentage_farthest_insertion.csv";
    public static BufferedWriter bw;
    public static BufferedWriter percentage1;
    public static BufferedWriter percentage2;
    public static BufferedWriter percentage3;

    public static void main(String[] args) throws IOException {
        String folderPath = "./benchmark_data";
        File folder = new File(folderPath);
        bw = new BufferedWriter(new FileWriter(reportFile));
        percentage2 = new BufferedWriter(new FileWriter(percentageReportForCheapestInsertion));
        percentage1 = new BufferedWriter(new FileWriter(percentageReportForNearestNeightbour));
        percentage3 = new BufferedWriter(new FileWriter(percentageReportForFarthestInsertion));
        bw.write("File, Total value, Nearest Neighbour,node swap, node shift , two-opt, Cheapest insertion, node swap, node shift, two-opt, Farthest insertion, node swap, node shift, two-opt\n");
        percentage1.write("File,Node Swap,Node Shift,Two-opt\n");
        percentage2.write("File,Node Swap,Node Shift,Two-opt\n");
        percentage3.write("File,Node Swap,Node Shift,Two-opt\n");
        if (folder.exists() && folder.isDirectory()) {
            String[] files = folder.list();
            if (files != null) {
                for (String filename : files) {
                    System.out.println("Now Processing inputs from file: " + filename);
                    bw.write(filename + ", ");
                    percentage1.write(filename + ", ");
                    percentage2.write(filename + ", ");
                    percentage3.write(filename + ", ");
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
        percentage1.close();
        percentage2.close();
        percentage3.close();
        System.out.println("Process finished successfully");
    }
}
