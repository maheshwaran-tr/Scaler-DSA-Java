package StackAndQueues;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterNum {
    public static void main(String[] args) {
        int[] a = {7, 6, 3, 8, 2, 11, 30, 5, 25};
//        int[] a = {5, 9, 6, 4, 17, 75, 50, 60, 70, 80};
        System.out.println(Arrays.toString(method2(a)));
    }

    static int[] method2(int[] nums) {
        int[] ans = new int[nums.length];
        Stack<Integer> st = new Stack<>();
        st.push(0);
        for (int i = 1; i < nums.length; i++) {
            while (!st.isEmpty() && nums[st.peek()] < nums[i]) {
                ans[st.pop()] = nums[i];
            }
            st.push(i);
        }

        while (!st.isEmpty()) {
            ans[st.pop()] = -1;
        }

        return ans;
    }

    static int[] method1(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[nums.length];
        stack.push(nums[nums.length - 1]);
        ans[nums.length - 1] = -1;

        for (int i = nums.length - 2; i >= 0; i--) {
            if (stack.peek() > nums[i]) {
                ans[i] = stack.peek();
                stack.push(nums[i]);
            } else {
                while (!stack.isEmpty() && stack.peek() < nums[i]) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    ans[i] = -1;
                } else {
                    ans[i] = stack.peek();
                }
                stack.push(nums[i]);
            }
        }
        return ans;
    }
}
