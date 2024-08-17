package HashmapProblems;

import java.util.HashMap;

public class LongestSubrrayDivByK {
    public static void main(String[] args) {
        int[] a = {4,5,0,-2,-3,1};
        System.out.println(longestSubarr(a, 5));
    }

    static int longestSubarr(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int maxLen = -1;
        int psum = 0;
        for (int i = 0; i < nums.length; i++) {
            psum += nums[i];
            int mod = ((psum % k) + k) % k;   // to handle negative numbers for %
            if (map.containsKey(mod)) {
                maxLen = Math.max(maxLen, i - map.get(mod));
            } else {
                map.put(mod, i);
            }
        }
        return maxLen;
    }
}
