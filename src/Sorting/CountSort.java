package Sorting;

import java.util.Arrays;

// TIME COMPLEXITY -> O(n + r)   r - range
// SPACE COMPLEXITY -> O(r)   r - range

public class CountSort {
    public static void main(String[] args) {
        int[] a = { 5, 4, 3, 2, 1 };
        System.out.println(Arrays.toString(sort(a)));
    }

    static int[] sort(int[] a) {

        // Finding Max Range
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
           max = Math.max(max, a[i]);
        }

        int[] p = new int[max + 1];

        // Frequency Array
        for (int i = 0; i < a.length; i++) {
            p[a[i]]++;
        }

        // Convert this to Prefix Sum Array
        for (int i = 1; i < p.length; i++) {
            p[i] = p[i - 1] + p[i];
        }

        // Reverse traverse the original array and update its position on prefix array
        // and ans array
        int[] ans = new int[a.length];
        for (int i = ans.length - 1; i >= 0; i--) {
            int pos = p[a[i]];
            ans[pos - 1] = a[i];
            p[a[i]]--;
        }

        return ans;
    }
}
