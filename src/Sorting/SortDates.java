package Sorting;

import java.util.Arrays;

public class SortDates {
    public static void main(String[] args) {
        String[] dates = { "05121968", "17121996", "05061997", "11081972", "11081990" };
        sortDates(dates);
        System.out.println(Arrays.toString(dates));
    }

    static void sortDates(String[] dates) {
        // Sorting basis of Date DD
        countSort(dates, 31, 1000000, 100);

        // Sorting basis of Month MM
        countSort(dates, 12, 10000, 100);

        // Sorting basis of Year YY
        countSort(dates, 2500, 1, 10000);
    }

    static void countSort(String[] a, int range, int div, int mod) {

        int[] p = new int[range + 1];

        // Frequency Array
        for (int i = 0; i < a.length; i++) {
            p[(Integer.parseInt(a[i]) / div) % mod]++;
        }

        // Convert this to Prefix Sum Array
        for (int i = 1; i < p.length; i++) {
            p[i] = p[i - 1] + p[i];
        }

        // Reverse traverse the original array and update its position on prefix array
        // and ans array

        String[] ans = new String[a.length];
        for (int i = ans.length - 1; i >= 0; i--) {
            int pos = p[(Integer.parseInt(a[i]) / div) % mod];
            ans[pos - 1] = a[i];
            p[(Integer.parseInt(a[i]) / div) % mod]--;
        }

        for (int i = 0; i < ans.length; i++) {
            a[i] = ans[i];
        }
    }
}
