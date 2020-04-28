package Java.Y2019.BOJ.stack;

import java.util.*;

public class N9012 {
    static Scanner in = new Scanner(System.in);
    static int T;
    static String input;
    static boolean answer;

    public static void main(String[] args) {
        T = in.nextInt();

        for (int i = 0; i < T; i++) {
            input = in.next();

            if (isVPS(input) == true) {
                System.out.println("YES");
            } else if (isVPS(input) == false) {
                System.out.println("NO");
            }
        }
    }

    static boolean isVPS(String str) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                stack.push(str.charAt(i));
            } else if (str.charAt(i) == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        if (stack.isEmpty()) {
            answer = true;
        } else {
            answer = false;
        }

        return answer;
    }
}
