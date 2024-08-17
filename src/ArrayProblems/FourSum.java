package ArrayProblems;
/*
 * 4 Sum
Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note:

Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
The solution set must not contain duplicate quadruplets.
Example : Given array S = {1 0 -1 0 -2 2}, and target = 0 A solution set is:

    (-2, -1, 1, 2)
    (-2,  0, 0, 2)
    (-1,  0, 0, 1)
Also make sure that the solution set is lexicographically sorted. Solution[i] < Solution[j] iff Solution[i][0] < Solution[j][0] OR (Solution[i][0] == Solution[j][0] AND ... Solution[i][k] < Solution[j][k])
 */

import java.util.ArrayList;
import java.util.Collections;

public class FourSum {
    public static void main(String[] args) {

    }

    public ArrayList<ArrayList<Integer>> fourSum(ArrayList<Integer> A, int B) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Collections.sort(A);

        int n = A.size();
        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && A.get(i).equals(A.get(i - 1)))
                continue; // Avoid duplicates for the first number

            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && A.get(j).equals(A.get(j - 1)))
                    continue; // Avoid duplicates for the second number

                int k = j + 1;
                int l = n - 1;
                while (k < l) {
                    int sum = A.get(i) + A.get(j) + A.get(k) + A.get(l);
                    if (sum == B) {
                        ArrayList<Integer> temp = new ArrayList<>();
                        temp.add(A.get(i));
                        temp.add(A.get(j));
                        temp.add(A.get(k));
                        temp.add(A.get(l));
                        ans.add(temp);

                        k++;
                        l--;

                        // Avoid duplicates for the third number
                        while (k < l && A.get(k).equals(A.get(k - 1)))
                            k++;

                        // Avoid duplicates for the fourth number
                        while (k < l && A.get(l).equals(A.get(l + 1)))
                            l--;

                    } else if (sum < B) {
                        k++;
                    } else {
                        l--;
                    }
                }
            }
        }

        return ans;
    }
}
