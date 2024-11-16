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
                Swap(i, j);
            }
        }
    }

    private void Swap(int pos1, int pos2) {
       float tempcost;
       Collections.swap(improvedPath, pos1 , pos2);
       tempcost = findTotalDistance();
       if(tempcost < cost)
       {
           cost = tempcost;
       }
       else {
           Collections.swap(improvedPath, pos1, pos2);
       }
    }
}
