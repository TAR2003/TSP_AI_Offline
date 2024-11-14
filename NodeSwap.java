import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class NodeSwap extends PerturbativeAlgorithm {
    public NodeSwap(ArrayList<City> path, float cost) {
        super(path, cost);
    }

    public void improveResult() {
        for (int i = 1; i < improvedPath.size() - 1; i++) {
            for (int j = 1; j < improvedPath.size() - 1; j++) {
                float tempcost = costAfterSwap(i, j);
                if (tempcost < cost) {
                    //System.out.println(tempcost + " is lower after swapping " + improvedPath.get(i) + " with " + improvedPath.get(j));
                    Collections.swap(improvedPath, i, j);
                    cost = tempcost;
                }
            }
        }
    }

    private float costAfterSwap(int pos1, int pos2) {
        float tempcost = cost;
       // System.out.println("Before " + tempcost);
        tempcost -= improvedPath.get(pos1).findDistance(improvedPath.get(pos1 - 1));
        tempcost -= improvedPath.get(pos1).findDistance(improvedPath.get(pos1 + 1));
        tempcost -= improvedPath.get(pos2).findDistance(improvedPath.get(pos2 - 1));
        tempcost -= improvedPath.get(pos2).findDistance(improvedPath.get(pos2 + 1));
       // System.out.println("Middle " + tempcost);
        tempcost += improvedPath.get(pos2).findDistance(improvedPath.get(pos1 - 1));
        tempcost += improvedPath.get(pos2).findDistance(improvedPath.get(pos1 + 1));
        tempcost += improvedPath.get(pos1).findDistance(improvedPath.get(pos2 - 1));
        tempcost += improvedPath.get(pos1).findDistance(improvedPath.get(pos2 + 1));
        //System.out.println("After " + tempcost);
        if(Math.abs(pos1 - pos2) == 1)
        {
            tempcost += 2 * (improvedPath.get(pos1).findDistance(improvedPath.get(pos2)));
        }
        return tempcost;
    }
}
