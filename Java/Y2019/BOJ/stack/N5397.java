package Java.Y2019.BOJ.stack;

import java.util.*;

//시간 초과
public class N5397 {
    static Stack<Character> stack1 = new Stack<>();
    static Stack<Character> stack2 = new Stack<>();
    static int t;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        t = in.nextInt();

        while (t-- != 0) {
            String str;
            str = in.next();

            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);

                if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9')) {
                    stack1.push(ch);
                }

                if (ch == '<' && !stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }

                if (ch == '>' && !stack2.isEmpty()) {
                    stack1.push(stack2.pop());
                }

                if (ch == '-' && !stack1.isEmpty()) {
                    stack1.pop();
                }
            }

            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }

            while (!stack2.isEmpty()) {
                System.out.print(stack2.pop());
            }

            System.out.println();
        }
    }
}
