// Traverse only once

package Sorting;

import java.util.Arrays;

public class SortZeroOneTwo {
    public static void main(String[] args) {
        int[] a = { 2, 2, 0, 1, 1, 0, 2, 2, 1, 0, 0, 1, 0 };
        sort(a);
        System.out.println(Arrays.toString(a));
    }

    private static void sort(int[] a) {
        int i = 0;
        int j = 0;
        int k = a.length - 1;

        while (j <= k) {
            if (a[j] == 2) {
                int temp = a[j];
                a[j] = a[k];
                a[k] = temp;
                k--;
            } else if (a[j] == 0) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i++;
                j++;
            } else {
                j++;
            }
        }
    }
}
