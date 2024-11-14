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

    public void processTSP() {
        SolverAlgorithm nearestNeighbour = new NearestNeighbour(cities);
        nearestNeighbour.findMinimumPath();
        printAnswers(nearestNeighbour.path, nearestNeighbour.cost);
        this.improveTSP(nearestNeighbour.path, nearestNeighbour.cost);
        // SolverAlgorithm cheapestInsertion = new CheapestInsertion(cities);
        // cheapestInsertion.findMinimumPath();
        // printAnswers(cheapestInsertion.path, cheapestInsertion.cost);
        // this.improveTSP(cheapestInsertion.path, cheapestInsertion.cost);
        // SolverAlgorithm farthestInsertion = new FarthestInsertion(cities);
        // farthestInsertion.findMinimumPath();
        // printAnswers(farthestInsertion.path, farthestInsertion.cost);
        // this.improveTSP(farthestInsertion.path, farthestInsertion.cost);

    }

    public void improveTSP(ArrayList<City> path, float cost) {
        System.out.println("Improving result");
        PerturbativeAlgorithm nodeSwap = new NodeSwap(path, cost);
        nodeSwap.improveResult();
        printAnswers(nodeSwap.improvedPath, nodeSwap.cost);
        PerturbativeAlgorithm nodeShift = new NodeShift(path, cost);
        nodeShift.improveResult();
        printAnswers(nodeShift.improvedPath, nodeShift.cost);
        // PerturbativeAlgorithm twoOpt = new TwoOpt(path, cost);
        // twoOpt.improveResult();
        // printAnswers(twoOpt.improvedPath, twoOpt.cost);
    }

    private void printAnswers(ArrayList<City> path, float cost) {
        for (City city : path) {
            System.out.print(city.id + " ");
        }
        System.out.println();
        System.out.println("Total cost: " + cost);
    }

}
