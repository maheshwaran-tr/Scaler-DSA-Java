package BinarySearch;

public class MatrixBinarySearch {
    public static void main(String[] args) {
        int[][] a = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 }
        };
        int target = 19;
        System.out.println(searchMatrix(a, target));
    }

    private static boolean searchMatrix(int[][] a, int target) {
        int i = 0;
        int j = a.length - 1;

        while (i < a.length && j >= 0) {
            if (a[i][j] == target) {
                return true;
            } else if (a[i][j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }
}