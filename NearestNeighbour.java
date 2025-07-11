import java.util.ArrayList;

public class NearestNeighbour extends SolverAlgorithm{

    public NearestNeighbour(ArrayList<City> cities) {
        super(cities);
    }

    /// find the minimum cost path with Nearest neighbour algorithm
    public void findMinimumPath() {
        System.out.println("Starting the nearest neaighbour algorithm");
        path.add(cities.get(0));
        path.add(cities.get(0));
        cost = 0;
        cities.get(0).visited = true;
        while (path.size() != cities.size() + 1) {
            City lastNode = path.get(path.size() - 2);
            City bestPick = findNearestCity(lastNode);
            bestPick.visited = true;
            path.add(path.size() - 1, bestPick);
            //System.out.println("Current size " + path.size());
            cost -= lastNode.findDistance(cities.get(0));
            cost += lastNode.findDistance(bestPick) + bestPick.findDistance(cities.get(0));
        }
    }
    /// find the nearest unvisited city from the city "from"
    private City findNearestCity(City from) {
        float smallestCost = Integer.MAX_VALUE;
        City bestPick = null;
        for (int i = 0; i < cities.size(); i++) {
            City to = cities.get(i);

            if (!to.visited) {
                float distance = from.findDistance(to);
                //System.out.println("From " + from.id + "  to = " + to.id + " : distance= " + distance);
                if (distance < smallestCost) {
                    smallestCost = distance;
                    bestPick = to;
                }
            }


        }
        return bestPick;
    }

}
