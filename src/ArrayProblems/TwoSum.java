package ArrayProblems;
import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        int[] arr = { 11, 3, 7, 9, 14, 2 };
        int target = 17;
        System.out.println(Arrays.toString(twoSum(arr, target)));
    }

    static int[] twoSum(int[] arr, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int bal = target - arr[i];
            if (map.containsKey(bal)) {
                return new int[] { map.get(bal), i };
            }
            map.put(arr[i], i);
        }
        return new int[] { -1, -1 };
    }
}