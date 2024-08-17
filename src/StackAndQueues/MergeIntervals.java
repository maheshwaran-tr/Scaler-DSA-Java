package StackAndQueues;

import java.util.Arrays;
import java.util.Stack;

public class MergeIntervals {
    public static void main(String[] args) {
//        int[][] intervals = {{1, 4}, {8, 12}, {3, 7}, {2, 6}, {9, 11}, {17, 25}, {15, 21}};
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] ans = mergeIntervals(intervals);
        for (int[] arr : ans) {
            System.out.println(arr[0] + " " + +arr[1]);
        }
    }

    private static int[][] mergeIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        Stack<int[]> stack = new Stack<>();
        stack.push(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            if (stack.peek()[1] >= intervals[i][0]) {
                stack.peek()[1] = Math.max(stack.peek()[1], intervals[i][1]);
            } else {
                stack.push(intervals[i]);
            }
        }

        int[][] ans = new int[stack.size()][2];
        for (int i = ans.length - 1; i >= 0; i--) {
            ans[i] = stack.peek();
            stack.pop();
        }

        return ans;
    }

}
