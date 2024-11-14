import java.util.ArrayList;

public class FarthestInsertion extends SolverAlgorithm{

    public FarthestInsertion(ArrayList<City> cities)
    {
        super(cities);
    }

    /// find the minimum cost path using the cheapest insertion algorithm
    public void findMinimumPath()
    {
        System.out.println("Starting the furthest insertion algorithm");
        path.add(cities.get(0));
        path.add(cities.get(0));
        cost = 0;
        cities.get(0).visited = true;
        while (path.size() != cities.size() + 1)
        {
            City city = this.getFarthestCity();
            city.visited = true;
            int bestIndex = this.bestIndexForInsertion(city);
            cost = this.insertionCostAtIndex(city, cost, bestIndex);
            path.add(bestIndex + 1, city);
            //System.out.println(path.toString());
        }
    }

    /// we check the minimal distances of all the unvisited vertices to any visited vertices
    private City getFarthestCity()
    {
        City bestPick = null;
        float minimalDistance = Integer.MAX_VALUE;
        for(int  i = 0 ; i < cities.size() ; i++)
        {
            City city = cities.get(i);
            if(!city.visited)
            {
                float tempval = this.getMinimalDistance(city);
                if(tempval < minimalDistance)
                {
                    bestPick = city;
                    minimalDistance = tempval;
                }
            }
        }
        return bestPick;
    }

    /// get the minimal distance of a unvisited city to any of the cities in the current path
    private float getMinimalDistance(City city)
    {
        float minimalDistance = Integer.MAX_VALUE;
        for(int  i = 0 ; i < path.size() - 1; i++)
        {
            minimalDistance = Float.min(minimalDistance, path.get(i).findDistance(city));
        }
        return minimalDistance;
    }

}
