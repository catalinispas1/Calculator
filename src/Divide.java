import java.util.LinkedList;
public class Divide {
    void getDivide(LinkedList<Double> numList, int vIndex) {
        double divide = numList.get(vIndex) / numList.get(vIndex + 1);
        numList.set(vIndex, divide);
        numList.remove(vIndex + 1);
    }
}
