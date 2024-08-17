import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        PriorityQueue<Integer> p = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 10; i >= 1; i--){
            p.add(i);
        }

        System.out.println(p);
    }
}