package Java.Y2019.BOJ.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();

        String input = br.readLine();
        while (!input.equals(".")) {
            stack.clear();

            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == '(' || input.charAt(i) == '[') {
                    stack.push(input.charAt(i));
                } else if (input.charAt(i) == ')' || input.charAt(i) == ']') {
                    if (stack.isEmpty() || (input.charAt(i) == ')' && stack.peek() != '(')
                    || (input.charAt(i) == ']' && stack.peek() != '[')) {
                        stack.push(input.charAt(i));
                        break;
                    }
                    stack.pop();
                }
            }

            if (stack.isEmpty()) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }

            input = br.readLine();
        }
    }
}
