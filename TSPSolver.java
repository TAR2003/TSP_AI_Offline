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
    public void processTSP()
    {

    }

}
