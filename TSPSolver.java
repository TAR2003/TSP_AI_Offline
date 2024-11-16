import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class TSPSolver {
    public ArrayList<City> cities;

    public TSPSolver(File file) throws IOException {
        System.out.println("In TSPSolver");
        TSPBuilder tspBuilder = new TSPBuilder(file);
        cities = tspBuilder.getCities();

    }

    public void processTSP() throws IOException {
        SolverAlgorithm nearestNeighbour = new NearestNeighbour(cities);
        nearestNeighbour.findMinimumPath();
        printAnswers(nearestNeighbour.path, nearestNeighbour.cost);
        this.improveTSP(nearestNeighbour.path, nearestNeighbour.cost);
         SolverAlgorithm cheapestInsertion = new CheapestInsertion(cities);
         cheapestInsertion.findMinimumPath();
         printAnswers(cheapestInsertion.path, cheapestInsertion.cost);
         this.improveTSP(cheapestInsertion.path, cheapestInsertion.cost);
         SolverAlgorithm farthestInsertion = new FarthestInsertion(cities);
         farthestInsertion.findMinimumPath();
         printAnswers(farthestInsertion.path, farthestInsertion.cost);
         this.improveTSP(farthestInsertion.path, farthestInsertion.cost);
         Main.bw.write("\n");

    }

    public void improveTSP(ArrayList<City> path, float cost) throws IOException {
        System.out.println("Improving result");
        PerturbativeAlgorithm nodeSwap = new NodeSwap(path, cost);
        nodeSwap.improveResult();
        System.out.println("After node swap");
        printAnswers(nodeSwap.improvedPath, nodeSwap.cost);
        PerturbativeAlgorithm nodeShift = new NodeShift(path, cost);
        nodeShift.improveResult();
        System.out.println("after ndde shift");
        printAnswers(nodeShift.improvedPath, nodeShift.cost);
        PerturbativeAlgorithm twoOpt = new TwoOpt(path, cost);
        twoOpt.improveResult();
        System.out.println("after two opt method");
        printAnswers(twoOpt.improvedPath, twoOpt.cost);
    }

    private void printAnswers(ArrayList<City> path, float cost) throws IOException {
        for (City city : path) {
            System.out.print(city.id + " ");
        }
        System.out.println();
        Main.bw.write(cost +" ,");
        System.out.println("Total cost: " + cost);
    }

}
