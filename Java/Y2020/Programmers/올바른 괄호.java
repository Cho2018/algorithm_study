import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            
            if (temp == '(') {
                stack.push(temp);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    char data = stack.peek();
                    
                    if (data == '(') {
                        stack.pop();
                    }
                }
            }
        }
        
        if (!stack.isEmpty()) {
            return false;
        }

        return answer;
    }
}
