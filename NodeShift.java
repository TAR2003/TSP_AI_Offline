import java.util.ArrayList;
import java.util.Collections;

public class NodeShift extends PerturbativeAlgorithm {
    public NodeShift(ArrayList<City> path, float cost) {
        super(path, cost);
    }

    /// this function will improve the path with node shifting
    public void improveResult() {
        System.out.println("Starting algo ");
        for (int i = 1; i < improvedPath.size() - 1; i++) {
            for (int j = 1; j < improvedPath.size() - 1; j++) {
                findShift(i, j);

            }
        }
    }

    private void findShift(int pos1, int pos2) {
        if (pos1 == pos2) return;
        City city = improvedPath.get(pos1);
        improvedPath.remove(pos1);
        improvedPath.add(pos2, city);
        float tempcost = findTotalDistance();
        if(tempcost < cost)
        {
            cost = tempcost;
        }
        else {
            improvedPath.remove(pos2);
            improvedPath.add(pos1, city);
        }

    }
}
