// Traverse only once


package Sorting;

import java.util.Arrays;

public class SortZeroAndOne {
    public static void main(String[] args) {
        int[] a = { 0, 0, 0, 1, 0, 1, 0, 0, 1, 1, 0, 0, 1 };
        sort(a);
        System.out.println(Arrays.toString(a));
    }

    private static void sort(int[] a) {
        int i = 0;
        int j = a.length - 1;

        while (i < j) {
            if (a[i] == 1 && a[j] == 0) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i++;
                j--;
            }
            while (a[i] == 0) {
                i++;
            }
            while (a[j] == 1) {
                j--;
            }
        }
    }
}
