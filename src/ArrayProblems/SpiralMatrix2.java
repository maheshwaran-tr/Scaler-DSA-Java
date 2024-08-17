package ArrayProblems;
/*
 * Spiral Order Matrix II
Problem Description
Given an integer A, generate a square matrix filled with elements from 1 to A2 in spiral order and return the generated square matrix.

Problem Constraints
1 <= A <= 1000

Input Format
First and only argument is integer A

Output Format
Return a 2-D matrix which consists of the elements added in spiral order.

Example Input
Input 1:

1
Input 2:

2
Input 3:

5


Example Output
Output 1:

[ [1] ]
Output 2:

[ [1, 2], 
  [4, 3] ]
Output 3:

[ [1,   2,  3,  4, 5], 
  [16, 17, 18, 19, 6], 
  [15, 24, 25, 20, 7], 
  [14, 23, 22, 21, 8], 
  [13, 12, 11, 10, 9] ]
 */


public class SpiralMatrix2 {
    public static void main(String[] args) {
        
    }

    static int[][] generateMatrix(int A) {
        int rs = 0, re = A - 1;
        int cs = 0, ce = A - 1;
        int count = 0;
        int[][] m = new int[A][A];

        while(count < A*A){
            for(int i = cs; i <= ce; i++){
                m[rs][i] = ++count;
            }
            rs++;

            for(int i = rs; i <= re; i++){
                m[i][ce] = ++count;
            }
            ce--;

            for(int i = ce; i >= cs; i--){
                m[re][i] = ++count;
            }
            re--;

            for(int i = re; i >= rs; i--){
                m[i][cs] = ++count;
            }
            cs++;
        }

        return m;
    }
}
