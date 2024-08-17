package Sorting;

import java.util.Arrays;

public class MergeTwoSortedArr {
    public static void main(String[] args) {
        int[] a1 = {2, 3, 8, 10, 12, 15};
        int[] a2 = {3, 5, 7, 11};
        int[] sorted = merge(a1, a2);
        System.out.println(Arrays.toString(sorted));
    }

    static int[] merge(int[] a1, int[] a2){
        int[] ans = new int[a1.length + a2.length];
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < a1.length && j < a2.length) {
            if(a1[i] <= a2[j]){
                ans[k++] = a1[i];
                i++;
            }else{
                ans[k++] = a2[j];
                j++;
            }
        }

        while (i < a1.length) {
            ans[k++] = a1[i];
            i++;
        }

        while (j < a2.length) {
            ans[k++] = a2[j];
            j++;
        }

        return ans;
    }
}
