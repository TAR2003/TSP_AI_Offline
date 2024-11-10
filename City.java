import static java.lang.Math.abs;

public class City {
    public int getId() {
        return id;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int id;
    public int x,y;
    public boolean visited;
    public City(int id, int x, int y)
    {
        this.id = id;
        this.x = x;
        this.y = y;
        this.visited = false;
    }

    @Override
    public String toString()
    {
        String str = "";
        str += id;
        str += " ";
        str += x;
        str +=  ' ';
        str += y;
        str += '\n';
        return str;
    }

    public int findDistance(City city)
    {
        int distance = 0;
        distance += abs(this.x - city.x);
        distance += abs(this.y - city.y);
        return distance;
    }



}
