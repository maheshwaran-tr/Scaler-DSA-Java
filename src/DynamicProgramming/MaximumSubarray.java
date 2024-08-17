package DynamicProgramming;
// KADANE'S ALGORITHM

public class MaximumSubarray {

    public static void main(String[] args) {
        int[] a = { 2, -3, 5, -2, 6, -8, 2, 1, 9, -6, 4 };
        System.out.println(maxSubarray(a));
    }

    static int maxSubarray(int[] a){
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        
        for(int i = 0; i < a.length; i++){
            currSum = Math.max(a[i], currSum + a[i]);
            maxSum = Math.max(maxSum, currSum);
        }

        return maxSum;
    }
}