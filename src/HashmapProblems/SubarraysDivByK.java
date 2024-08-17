package HashmapProblems;

import java.util.HashMap;

public class SubarraysDivByK {
    public static void main(String[] args) {
        int[] a = {4, 5, 0, -2, -3, 1};
        System.out.println(subarraysDivByK(a, 5));
    }

    static int subarraysDivByK(int[] nums, int k) {
        // HashMap to store the frequency of mod values
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);  // Initialize with mod 0 having frequency 1

        int cnt = 0;
        int psum = 0;

        for (int i = 0; i < nums.length; i++) {
            psum += nums[i];
            int mod = ((psum % k) + k) % k;  // To handle negative numbers

            // If mod value has been seen before, increment count by the frequency
            if (map.containsKey(mod)) {
                cnt += map.get(mod);
            }

            // Update the frequency of the current mod value
            map.put(mod, map.getOrDefault(mod, 0) + 1);
        }
        return cnt;
    }
}
