package HashmapProblems;

import java.util.HashMap;

public class SubarraysWithSumK {
    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        System.out.println(subarraySum(a, 3));
    }

    static int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int cnt = 0;

        int psum = 0;
        for (int i = 0; i < nums.length; i++) {
            psum += nums[i];
            if (map.containsKey(psum - k)) {
                cnt += map.get(psum - k);
            }
            map.put(psum, map.getOrDefault(psum, 0) + 1);
        }

        return cnt;
    }
}
