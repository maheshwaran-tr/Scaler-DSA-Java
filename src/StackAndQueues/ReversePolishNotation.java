package StackAndQueues;

import java.util.Stack;

public class ReversePolishNotation {
    public static void main(String[] args) {
        String[] s = {"4", "13", "5", "/", "+" };
//        String[] s = {"2", "1", "+", "3", "*"};
        System.out.println(evalRPN(s));
    }

    static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int pop1 = stack.pop();
                int pop2 = stack.pop();
                stack.push(solve(pop1, pop2, token));
            } else {
                stack.push(Integer.parseInt(token));
            }
            System.out.println(stack);
        }
        return stack.pop();
    }

    static int solve(int p1, int p2, String op) {
        switch (op) {
            case "+":
                return p1 + p2;
            case "-":
                return p2 - p1;
            case "*":
                return p1 * p2;
            case "/":
                return p2 / p1;
        }
        return 0;
    }

}
