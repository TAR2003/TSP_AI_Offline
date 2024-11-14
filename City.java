import java.util.ArrayList;

import static java.lang.Math.abs;

public class City {
    public int getId() {
        return id;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public int id;
    public float x;
    public float y;
    public boolean visited;
    public City(int id, float x, float y)
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

    public float findDistance(City city)
    {
        float distance = 0;
        distance +=abs(this.x - city.x);
        distance += abs(this.y - city.y);
        return distance;
    }




}