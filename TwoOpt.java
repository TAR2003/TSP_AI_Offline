import java.util.ArrayList;
import java.util.Collections;

public class TwoOpt extends PerturbativeAlgorithm{
    public TwoOpt(ArrayList<City> path, float cost) {
        super(path, cost);
    }

    /// Calculate the minimum path improvement
    public void improveResult()
    {
        System.out.println("Starting algorithm for Two-opt");
        for(int i = 1 ; i < path.size() - 2 ; i++)
        {
            for(int j = i+1 ; j < path.size() - 1 ; j++)
            {
                applyTwoOpt(i,j);
            }
        }
    }

    private void applyTwoOpt(int i , int j)
    {
        int start = Integer.min(i,j);
        int end = Integer.max(i,j);
        if(i == j) return;
        float distance = improvedPath.get(start).findDistance(improvedPath.get(end)) + improvedPath.get(start+1).findDistance(improvedPath.get(end+1))
                - improvedPath.get(start).findDistance(improvedPath.get(start+1)) - improvedPath.get(end).findDistance(improvedPath.get(end+1));
        if(distance < 0) {

            Collections.reverse(improvedPath.subList(start+1, end+1));
            cost = findTotalDistance();
        }

    }
}
