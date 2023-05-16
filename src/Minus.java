import java.util.LinkedList;
public class Minus {
    void getDifference(LinkedList<Double> numList, int vIndex) {
        double difference = numList.get(vIndex) - numList.get(vIndex + 1);
        numList.set(vIndex, difference);
        numList.remove(vIndex+1);
    }
}
