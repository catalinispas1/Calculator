import java.util.Arrays;
import java.util.LinkedList;

public class Input {
    Plus plus = new Plus();
    Minus minus = new Minus();
    Multiplication multiplication = new Multiplication();
    Divide divide = new Divide();
    Hashtag hashtag = new Hashtag();
    double calculateNow(String[] calculateList){

        LinkedList<Double> numList = new LinkedList<>();
        LinkedList<Character> operationsList = new LinkedList<>();

        if(calculateList.length % 2 == 0){
            calculateList = Arrays.copyOf(calculateList, calculateList.length - 1);
        }

        for(int i = 0; i < calculateList.length; i++){
            if(i % 2 == 0){
                if(calculateList[i].equals(".")) continue;
                numList.add(Double.parseDouble(calculateList[i]));
            } else {
                operationsList.add(calculateList[i].charAt(0));
            }
        }

        int priority = 2;
        while(priority >= 0) {
            for(int i=0; i<operationsList.size(); i++) {
                if(priority == 2) {
                    if(operationsList.get(i) == '*') {
                        multiplication.getMultiplication(numList, i);
                        operationsList.remove(i);
                        i--;
                    }
                    else if(operationsList.get(i) == '/') {
                        divide.getDivide(numList, i);
                        operationsList.remove(i);
                        i--;
                    }
                }
                else if(priority == 1) {
                    if(operationsList.get(i) == '#') {
                        hashtag.getHashtag(numList, i);
                        operationsList.remove(i);
                        i--;
                    }
                }
                else if (priority == 0) {
                    if(operationsList.get(i) == '+') {
                        plus.getGathering(numList, i);
                        operationsList.remove(i);
                        i--;
                    }
                    else if(operationsList.get(i) == '-') {
                        minus.getDifference(numList, i);
                        operationsList.remove(i);
                        i--;
                    }
                }
            }
            priority--;
        }
        return numList.get(0);
    }
}
