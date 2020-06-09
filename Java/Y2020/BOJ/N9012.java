package Java.Y2020.BOJ;

import java.io.*;
import java.util.*;

public class N9012 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();
        while (t-- > 0) {
            String s = in.next();
            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                if (stack.isEmpty()) {
                    if (c == ')') {
                        stack.push(c);
                        break;
                    } else {
                        stack.push(c);
                    }
                } else {
                    if (c == '(') {
                        stack.push(c);
                    } else {
                        if (stack.peek() == '(') {
                            stack.pop();
                        }
                    }
                }
            }

            if (!stack.isEmpty()) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }
    }
}
