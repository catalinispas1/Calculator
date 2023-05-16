import java.util.LinkedList;
public class Multiplication {
    void getMultiplication(LinkedList<Double> numList, int vIndex) {
        double multiplication = numList.get(vIndex) * numList.get(vIndex + 1);
        numList.set(vIndex, multiplication);
        numList.remove(vIndex + 1);
    }
}
