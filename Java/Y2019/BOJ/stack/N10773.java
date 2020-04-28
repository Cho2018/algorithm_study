package Java.Y2019.BOJ.stack;

import java.util.*;

public class N10773 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int K = in.nextInt();

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < K; i++) {
            int x = in.nextInt();

            if (x != 0) {
                stack.push(x);
            } else {
                stack.pop();
            }
        }

        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }

        System.out.println(sum);
    }
}
