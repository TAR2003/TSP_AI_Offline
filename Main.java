import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("rat19.tsp"));
        ArrayList<City> cities = new ArrayList<>(10);
        boolean startcommand = false;
        int total = 0;
        int size = 0;
        while (true) {
            String str = br.readLine();
            if (str == null) break;
            String[] strings1 = str.split(" ");
            if (strings1[0].equalsIgnoreCase("DIMENSION")) {

                size = Integer.parseInt(strings1[2]);
                // System.out.println("The size = " + size);
            }
            //System.out.println(str);
            if (startcommand) {

                String[] strings = str.split(" ");
                int pos = 0;
                while (strings[pos].length() == 0) {
                    pos++;
                }

                int cityid = Integer.parseInt(strings[pos++]);
                while (strings[pos].length() == 0) {
                    pos++;
                }
                int x = Integer.parseInt(strings[pos++]);
                while (strings[pos].length() == 0) {
                    pos++;
                }
                int y = Integer.parseInt(strings[pos]);
                City city = new City(cityid, x, y);
                cities.add(city);
                total++;
                if (total >= size) {
                    break;
                }

            }
            if (str.equalsIgnoreCase("NODE_COORD_SECTION")) {
                startcommand = true;
            }

        }
        br.close();
        System.out.println(cities.size());
        /*
        for (int i = 0; i < cities.size(); i++) {
            System.out.println(cities.get(i));
        }
        */
        System.out.println("DOne");
        System.out.println("Process finished successfully");
        // Now we are going to calculate the distances between cities
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>(1);
        for (int i = 0; i < size; i++) {
            ArrayList<Integer> tempList = new ArrayList<>(1);
            for (int j = 0; j < size; j++) {
                tempList.add(cities.get(i).findDistance(cities.get(j)));
            }
            matrix.add(tempList);
        }
        NearestDistance nearestDistance = new NearestDistance(cities, matrix);

        ArrayList<Integer> roundTrip = nearestDistance.getNearestNeighbour();
        for (int i = 0; i < size; i++) {
            System.out.print(roundTrip.get(i) + " ");
        }
        System.out.println();
        System.out.println(countCost(cities, matrix, roundTrip));
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(matrix.get(i).get(j) + " ");
            }
            System.out.println();

        }
        // it is the matrix where we will store all of the distances


    }

    public static int countCost(ArrayList<City> cities, ArrayList<ArrayList<Integer>> matrix, ArrayList<Integer> roundTrip) {
        int distance = 0;
        int size = matrix.size();
        for (int i = 0; i < size - 1; i++) {
            distance += matrix.get(roundTrip.get(i)).get(roundTrip.get(i+1));
            System.out.println("Distance in " + i + " =  " + distance);
        }
        System.out.println("Distance in after  " + " =  " + distance);
        System.out.println(roundTrip.get(size - 1) + " " + roundTrip.get(0));
        distance += matrix.get(roundTrip.get(size - 1)).get(roundTrip.get(0));
        return distance;
    }


}
