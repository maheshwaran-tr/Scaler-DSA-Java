package Sorting;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] a = { 2, 4, 5, 2, 4, 2, 1 };
        int[] sortedArr = sort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(sortedArr));
    }

    static int[] sort(int[] A, int s, int e) {
        if (s == e) {
            int[] newArr = new int[1];
            newArr[0] = A[s];
            return newArr;
        }
        int mid = (s + e) / 2;
        int[] f = sort(A, s, mid);
        int[] se = sort(A, mid + 1, e);
        int[] arr = merge(f, se);
        return arr;
    }

    static int[] merge(int[] A, int[] B) {
        int i = 0;
        int j = 0;
        int k = 0;
        int[] ans = new int[A.length + B.length];
        while (i < A.length && j < B.length) {
            if (A[i] <= B[j]) {
                ans[k++] = A[i];
                i++;
            } else {
                ans[k++] = B[j];
                j++;
            }
        }

        while (i < A.length) {
            ans[k++] = A[i];
            i++;
        }
        while (j < B.length) {
            ans[k++] = B[j];
            j++;
        }

        return ans;
    }
}
