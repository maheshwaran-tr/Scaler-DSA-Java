package HashmapProblems;

import java.util.HashMap;

public class LongestSubarrayWithSumK {
    public static void main(String[] args) {
        int[] a = {10, 5, 2, 7, 1, 9};
        System.out.println(longestSubarray(a, 15));
    }

    static int longestSubarray(int[] nums, int k) {
        int maxlen = -1;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int psum = 0;
        for (int i = 0; i < nums.length; i++) {
            psum += nums[i];
            if (map.containsKey(psum - k)) {
                maxlen = Math.max(maxlen, i - map.get(psum - k));
            }

            if (!map.containsKey(psum)) {
                map.put(psum, i);
            }
        }

        return maxlen;
    }
}
