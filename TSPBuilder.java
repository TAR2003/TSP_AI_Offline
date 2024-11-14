import java.io.*;
import java.util.ArrayList;

public class TSPBuilder {
    public File file;

    public TSPBuilder(File file) {
        this.file = file;
    }

    public ArrayList<City> getCities() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        ArrayList<City> cities = new ArrayList<>(10);
        boolean startcommand = false;
        int total = 0;
        int size = 0;
        while (true) {
            String str = br.readLine();
            if (str == null) break;
            String[] strings1 = str.split(" ");


            if ((strings1[0]).toUpperCase().startsWith("DIMENSION")) {
                size = Integer.parseInt(strings1[strings1.length - 1]);
            }
            if (startcommand) {
                City city = getCity(str);
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
        return cities;


    }

    private static City getCity(String str) {
        String[] strings = str.split(" ");
        int pos = 0;
        while (strings[pos].isEmpty()) {
            pos++;
        }

        int cityid = Integer.parseInt(strings[pos++]);
        while (strings[pos].isEmpty()) {
            pos++;
        }
        float x = Float.parseFloat(strings[pos++]);
        while (strings[pos].isEmpty()) {
            pos++;
        }
        float y = Float.parseFloat(strings[pos]);
        return new City(cityid, x, y);
    }

}
