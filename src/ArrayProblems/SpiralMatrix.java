package ArrayProblems;
public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] a = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 }
        };

        spiral(a);
    }

    static void spiral(int[][] a) {
        int rowStart = 0, rowEnd = a.length - 1;
        int colStart = 0, colEnd = a[0].length - 1;

        int count = 0;

        while (count < a.length * a[0].length) {
            // top
            for (int i = colStart; i <= colEnd; i++) {
                System.out.print(a[rowStart][i] + " ");
                count++;
            }
            rowStart++;

            // right
            for (int i = rowStart; i <= rowEnd; i++) {
                System.out.print(a[i][colEnd] + " ");
                count++;
            }
            colEnd--;

            // bottom
            for (int i = colEnd; i >= colStart; i--) {
                System.out.print(a[rowEnd][i] + " ");
                count++;
            }
            rowEnd--;

            // left
            for (int i = rowEnd; i >= rowStart; i--) {
                System.out.print(a[i][colStart] + " ");
                count++;
            }
            colStart++;
        }
    }
}
