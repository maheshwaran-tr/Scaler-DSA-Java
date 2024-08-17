import java.util.Stack;

public class ValidParantheses {
    public static void main(String[] args) {
        String s = "(])]";
        System.out.println(isValid(s));
    }

    static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (Character sm : s.toCharArray()) {
            if (sm == ')' || sm == ']' || sm == '}') {
                if (stack.size() == 0)
                    return false;
                Character popped = stack.pop();
                if (popped == '(' && sm != ')') {
                    return false;
                }
                if (popped == '[' && sm != ']') {
                    return false;
                }
                if (popped == '{' && sm != '}') {
                    return false;
                }
            } else {
                stack.push(sm);
            }
        }

        if (stack.size() == 0)
            return true;
        return false;
    }
}
