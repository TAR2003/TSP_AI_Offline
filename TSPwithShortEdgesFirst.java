import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class TSPwithShortEdgesFirst {

    public ArrayList<ArrayList<Integer>> matrix;
    public ArrayList<City> cities;

    public TSPwithShortEdgesFirst(ArrayList<City> cities, ArrayList<ArrayList<Integer>> matrix) {
        this.matrix = matrix;
        this.cities = cities;
    }

    public ArrayList<Integer> getNearestNeighbour() {
        int size = cities.size();
        Main.makeCitiedUnvisited(cities);
        ArrayList<Integer> roundTrip = new ArrayList<>(size);
        ArrayList<Edge> allEdges = new ArrayList<>(2);
        for(int i = 0 ;  i < size ; i++)
        {
            for(int j = i + 1 ; j < size ; j++)
            {
                Edge tempEdge = new Edge(matrix.get(i).get(j), cities.get(i),cities.get(j));
                allEdges.add(tempEdge);
            }
        }
        Collections.sort(allEdges);
        // sorted all the edges as their weight/distance
//        for(int i= 0; i < allEdges.size() ; i++)
//        {
//            System.out.println(allEdges.get(i));
//        }

        int currentTotal = 0;
        int pos = 0;
        while(currentTotal<size)
        {

        }
        Main.makeCitiedUnvisited(cities);
        return roundTrip;
    }


}


class Edge implements Comparable<Edge>
{
    public int weight;
    public City city1, city2;
    public Edge(int weight, City city1, City city2)
    {
        this.weight = weight;
        this.city1 = city1;
        this.city2 = city2;
    }
    @Override
    public int compareTo(Edge edge)
    {
        return Integer.compare(this.weight, edge.weight);
    }
    @Override
    public String toString()
    {
        String str = "Edge: Weight= ";
        str += weight;
        str += " ,";
        str += city1.toString();
        str += city2.toString();
        return str;
    }



}

