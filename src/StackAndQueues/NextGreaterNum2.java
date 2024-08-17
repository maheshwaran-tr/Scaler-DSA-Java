package StackAndQueues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

// Circular Array

public class NextGreaterNum2 {
    public static void main(String[] args) {
        int[] a = {1, 2, 1};
        System.out.println(Arrays.toString(nextGreaterElement(a)));
    }

    static int[] nextGreaterElement(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        ArrayList<Integer> an = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        st.push(0);
        for (int i = 1; i < 2 * n; i++) {
            while (!st.isEmpty() && nums[st.peek()] < nums[i % n]) {
                ans[st.pop()] = nums[i % n];
            }
            st.push(i % n);
        }

        return ans;
    }
}
