import java.util.ArrayList;
import java.util.Collections;

public class NodeShift extends PerturbativeAlgorithm {
    public NodeShift(ArrayList<City> path, float cost) {
        super(path, cost);
    }

    /// this function will improve the path with node shifting
    public void improveResult() {
        System.out.println("Starting algo " + improvedPath.toString());
        for (int i = 1; i < improvedPath.size() - 1; i++) {
            for (int j = 1; j < improvedPath.size() - 1; j++) {
                float tempcost = findShiftCost(i, j);
                if (tempcost < cost) {
                    City city = improvedPath.get(i);

                    improvedPath.remove(i);
                    if (i < j) {
                        improvedPath.add(j - 1, city);
                    } else {
                        improvedPath.add(j, city);
                    }
                    cost = tempcost;
                }
            }
        }
    }

    private float findShiftCost(int pos1, int pos2) {
        if (pos1 == pos2) return cost;
        float tempcost = cost;
        tempcost -= improvedPath.get(pos1).findDistance(improvedPath.get(pos1 - 1));
        tempcost -= improvedPath.get(pos1).findDistance(improvedPath.get(pos1 + 1));
        tempcost -= improvedPath.get(pos2).findDistance(improvedPath.get(pos2 - 1));
        tempcost += improvedPath.get(pos1 - 1).findDistance(improvedPath.get(pos1 + 1));
        tempcost += improvedPath.get(pos2).findDistance(improvedPath.get(pos1));
        if (pos2 - 1 == pos1) {
            tempcost += improvedPath.get(pos2).findDistance(improvedPath.get(pos1));
        } else {
            tempcost += improvedPath.get(pos2 - 1).findDistance(improvedPath.get(pos1));
        }
        return tempcost;
    }
}
