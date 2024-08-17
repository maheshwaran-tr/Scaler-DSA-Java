package ArrayProblems;
import java.util.Arrays;

public class RotateArray90Deg {
    public static void main(String[] args) {
        int[][] a = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 }
        };

        rotate90(a);

        for (int i = 0; i < a.length; i++) {
            System.out.println(Arrays.toString(a[i]));
        }
    }

    static void rotate90(int[][] a) {
        // Transpose Matrix
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a[i].length; j++) {
                int temp = a[i][j];
                a[i][j] = a[j][i];
                a[j][i] = temp;
            }
        }

        // Swap columns
        int left = 0;
        int right = a.length - 1;
        while (left < right) {
            for (int i = 0; i < a.length; i++) {
                int temp = a[i][left];
                a[i][left] = a[i][right];
                a[i][right] = temp;
            }

            left++;
            right--;
        }
    }
}