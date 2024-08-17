package Sorting;

import java.util.Arrays;

// TIME COMPLEXITY -> O(d*(n+r))    d -> maximum digits, r -> range
// SPACE COMPLEXITY -> O(1)

public class RadixSort {
    public static void main(String[] args) {
        int[] a = { 7865, 6574, 5643, 99, 110, 9, 92, 778 };
        radixSort(a);
        System.out.println(Arrays.toString(a));
    }

    static void radixSort(int[] a) {
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            max = Math.max(max, a[i]);
        }

        int exp = 1;
        while (max > 0) {
            max /= 10;
            countSort(a, exp);
            exp *= 10;
        }
    }

    static void countSort(int[] a, int exp) {

        // Finding Max Range
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            max = Math.max(max, (a[i] / exp) % 10);
        }

        int[] p = new int[max + 1];

        // Frequency Array
        for (int i = 0; i < a.length; i++) {
            p[(a[i] / exp) % 10]++;
        }

        // Convert this to Prefix Sum Array
        for (int i = 1; i < p.length; i++) {
            p[i] = p[i - 1] + p[i];
        }

        // Reverse traverse the original array and update its position on prefix array
        // and ans array
        
        int[] ans = new int[a.length];
        for (int i = ans.length - 1; i >= 0; i--) {
            int pos = p[(a[i] / exp) % 10];
            ans[pos - 1] = a[i];
            p[(a[i] / exp) % 10]--;
        }

        for (int i = 0; i < ans.length; i++) {
            a[i] = ans[i];
        }
    }
}
