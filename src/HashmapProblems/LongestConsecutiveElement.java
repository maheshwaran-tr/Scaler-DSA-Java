package HashmapProblems;

import java.util.HashMap;


public class LongestConsecutiveElement {
    public static void main(String[] args) {
        int[] a = {12, 4, 8, 13,  2, 3, 11, 5, 10, 6, 9, 25, 26};
        System.out.println(longestConsecutive(a));
    }

    static int longestConsecutive(int[] nums) {
        HashMap<Integer, Boolean> map = new HashMap<>();

        // 1. Assume every element is the starting point of sequence.
        for (int n : nums) {
            map.put(n, true);
        }

        // 2. Find valid starting point
        for (int n : nums) {
            if (map.containsKey(n - 1)) {
                map.put(n, false);
            }
        }

        // 3. For every valid starting point find consecutive sequence.
        int maxLen = 0;
        for (int n : nums) {
            if (map.get(n)) {
                int val = n;
                int currLen = 1;
                while (map.containsKey(val + 1)) {
                    currLen++;
                    val++;
                }
                maxLen = Math.max(currLen, maxLen);
            }
        }
        return maxLen;
    }
}
