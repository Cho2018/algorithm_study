import java.util.*;

class Solution {
    public boolean isValid(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            char temp;

            if (c == '(') {
                stack.push('(');
            } else if (c == '{') {
                stack.push('{');
            } else if (c == '[') {
                stack.push('[');
            } else if (c == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    answer = false;
                    break;
                } else {
                    stack.pop();
                }
            } else if (c == '}') {
                if (stack.isEmpty() || stack.peek() != '{' ) {
                    answer = false;
                    break;
                } else {
                    stack.pop();
                }
            } else if (c == ']') {
                if (stack.isEmpty() || stack.peek() != '[' ) {
                    answer = false;
                    break;
                } else {
                    stack.pop();
                }
            }
        }

        if (!stack.isEmpty()) {
            answer = false;
        }

        return answer;
    }
}
