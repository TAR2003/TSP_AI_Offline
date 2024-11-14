import java.util.ArrayList;

public class SolverAlgorithm {
    /// the arraylist of all the cities in the inputs
    public ArrayList<City> cities;
    float cost = 0;
    ArrayList<City> path = new ArrayList<>(1);

    public SolverAlgorithm(ArrayList<City> cities) {
        this.cities = cities;
        this.initAllCities();
    }

    /// this function will be overridden by its child classes
    public void findMinimumPath() {

    }

    /// find the best place to insert city in the current path
    public int bestIndexForInsertion(City city) {
        float tempval = Integer.MAX_VALUE;
        int position = 0;
        for (int i = 0; i < path.size() - 1; i++) {
            float tempcost = insertionCostAtIndex(city, cost, i);
            if (tempval > tempcost) {
                tempval = tempcost;
                position = i;
            }
        }
        return position;
    }

    /// find the worst place to insert city in the current path
    public int worstIndexForInsertion(City city) {
        float tempval = 0;
        int position = 0;
        for (int i = 0; i < path.size() - 1; i++) {
            float tempcost = insertionCostAtIndex(city, cost, i);
            if (tempval < tempcost) {
                tempval = tempcost;
                position = i;
            }
        }
        return position;
    }


    /// find the insertion cost if we insert them at index i
    public float insertionCostAtIndex(City city, float cost, int index) {
        cost -= path.get(index).findDistance(path.get(index + 1));
        cost += path.get(index).findDistance(city);
        cost += path.get(index + 1).findDistance(city);
        return cost;
    }

    private void initAllCities()
    {
        for(City city:cities)
        {
            city.visited = false;
        }
    }


}
