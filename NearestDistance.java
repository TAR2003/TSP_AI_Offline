import java.util.ArrayList;

public class NearestDistance {
    public ArrayList<ArrayList<Integer>> matrix;
    public ArrayList<City> cities;

    public NearestDistance(ArrayList<City> cities, ArrayList<ArrayList<Integer>> matrix)
    {
        this.matrix = matrix;
        this.cities = cities;
    }
    public ArrayList<Integer> getNearestNeighbour() {
        int size = cities.size();
        Main.makeCitiedUnvisited(cities);
        ArrayList<Integer> roundTrip = new ArrayList<>(size);
        roundTrip.add(0);
        cities.get(0).visited = true;
        int currentNode = 0;
        int total = 1;
        while (roundTrip.size() < size) {
            int selected = -1;
            int min = Integer.MAX_VALUE;
            cities.get(currentNode).visited = true;
            for (int i = 0; i < size; i++) {
                int mval = matrix.get(currentNode).get(i);
                if (!cities.get(i).visited && mval < min && i != currentNode) {
                    selected = i;
                    min = mval;
                }

            }
            if(selected == -1) return roundTrip;
            else roundTrip.add(selected);
            currentNode = selected;


        }
        Main.makeCitiedUnvisited(cities);
        return roundTrip;
    }

}
