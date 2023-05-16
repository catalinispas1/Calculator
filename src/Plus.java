import java.util.LinkedList;

public class Plus {
    void getGathering(LinkedList<Double> numList, int vIndex) {
        double gathering = numList.get(vIndex) + numList.get(vIndex + 1);
        numList.set(vIndex, gathering);
        numList.remove(vIndex + 1);
    }
}
