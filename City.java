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
        return str;
    }

    public float findDistance(City city)
    {
        float distance = 0;
        distance += (float) Math.pow(abs(this.x - city.x), 2);
        distance += (float) Math.pow(abs(this.y - city.y), 2);
        distance = (float) Math.sqrt(distance);
        return distance;
    }




}