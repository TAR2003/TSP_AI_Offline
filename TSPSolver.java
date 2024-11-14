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
    private void initAllCities()
    {
        for(City city:cities)
        {
            city.visited = false;
        }
    }
    public void processTSP()
    {

        NearestNeighbour nearestNeighbour = new NearestNeighbour(cities);
        nearestNeighbour.findMinimumPath();
        ArrayList<City> path = nearestNeighbour.path;
        for(City city : path)
        {
            System.out.print(city.id + " ");
        }
        System.out.println();
        System.out.println("Total cost: " + nearestNeighbour.cost);
    }

}
