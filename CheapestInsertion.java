import java.util.ArrayList;

public class CheapestInsertion extends SolverAlgorithm{


    public CheapestInsertion(ArrayList<City> cities) {
        super(cities);
    }

    /// find the minimum cost path using the cheapest insertion algorithm
    public void findMinimumPath() {
        System.out.println("Starting the cheapest insertion algorithm");
        path.add(cities.get(0));
        path.add(cities.get(0));
        cost = 0;
        cities.get(0).visited = true;
        while (path.size() != cities.size() + 1) {
            City city = this.getCheapestInsetionableCity();
            city.visited = true;
            int bestIndex = this.bestIndexForInsertion(city);
            cost = this.insertionCostAtIndex(city, cost, bestIndex);
            path.add(bestIndex + 1, city);
        }
        System.out.println("We are done in cheapest insertion process");
    }

    /// we check all the remaining unvisited nodes and check by inserting them into all possible locations to find the minimum value possible
    private City getCheapestInsetionableCity() {
        float initialCost = Integer.MAX_VALUE;
        City bestPick = null;
        for (int i = 0; i < cities.size(); i++) {
            if (!cities.get(i).visited) {
                float tempval = getCheapestInsertionCost(cities.get(i), cost);
                // we only take the minimum cost possible
                if (tempval < initialCost) {
                    initialCost = tempval;
                    // if initial cost is lesser, we pick the city
                    bestPick = cities.get(i);
                }

            }
        }
        return bestPick;
    }

    /// we are checking the cheapest insertion cost for a city
    private float getCheapestInsertionCost(City city, float cost) {
        float tempval = Integer.MAX_VALUE;
        for (int i = 0; i < path.size() - 1; i++) {
            tempval = Float.min(tempval, insertionCostAtIndex(city, cost, i));
        }
        return tempval;
    }



}
