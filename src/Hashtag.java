import java.util.LinkedList;

public class Hashtag {
    void getHashtag(LinkedList<Double> numList, int vIndex) {
        double hashtag = (numList.get(vIndex) + numList.get(vIndex + 1)) * (numList.get(vIndex) + numList.get(vIndex + 1));
        numList.set(vIndex, hashtag);
        numList.remove(vIndex + 1);
    }
}
