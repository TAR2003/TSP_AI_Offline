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
        for(int i = 1 ; i < path.size() ; i++)
        {
            for(int j = i+1 ; j < path.size() ; j++)
            {
                applyTwoOpt(i,j);
            }
        }
    }

    private void applyTwoOpt(int i , int j)
    {
        Collections.reverse(improvedPath.subList(i+1,j));
        float tempcost = findTotalDistance();
        if(tempcost < cost)
        {
            cost = tempcost;
        }
        else
        {
            Collections.reverse(improvedPath.subList(i+1, j));
        }

    }
}
