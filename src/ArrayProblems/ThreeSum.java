package ArrayProblems;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * a[i] + a[j] + a[k] = target
 */

public class ThreeSum {
    public static void main(String[] args) {
        int[] arr = { 7, -6, 3, 8, -1, 8, -11 };
        // int target = 0;
        System.out.println(threeSum(arr));
    }

    static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
    

        int n = nums.length;
        for(int i = 0; i < n; i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;

            int j = i + 1;
            int k = n - 1;
            while(j < k){
                int tot = nums[i] + nums[j] + nums[k];
                if(tot > 0) k--;
                else if(tot < 0) j++;
                else{
                    ans.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    j++;
                    while (nums[j] == nums[j-1] && j < k) {
                        j++;
                    }
                }
            }
        }
        return ans;
    }
}
