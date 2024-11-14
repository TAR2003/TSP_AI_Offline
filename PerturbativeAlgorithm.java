import java.util.ArrayList;

public class PerturbativeAlgorithm {
    ArrayList<City> path;
    ArrayList<City> improvedPath;
    float cost;
    public PerturbativeAlgorithm(ArrayList<City> path, float cost)
    {
        this.path = path;
        this.cost = cost;
        this.improvedPath = (ArrayList<City>) path.clone();
    }

    /// this function is going to be overridden by its child classes
    public void improveResult()
    {

    }

    public float findTotalDistance()
    {
        float distance = 0;
        for(int i = 0 ; i < improvedPath.size() - 1; i++)
        {
            distance += improvedPath.get(i).findDistance(improvedPath.get(i+1));
        }
        return distance;
    }


}
