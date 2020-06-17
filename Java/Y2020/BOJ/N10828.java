package Java.Y2020.BOJ;

import java.io.*;
import java.util.*;

public class N10828 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        Stack<Integer> stack = new Stack<>();

        while (n-- > 0) {
            String order = in.next();

            if (order.equals("push")) {
                int data = in.nextInt();

                stack.push(data);
            } else if (order.equals("pop")) {
                System.out.println(stack.isEmpty()? -1 : stack.pop());
            } else if (order.equals("size")) {
                System.out.println(stack.size());
            } else if (order.equals("empty")) {
                System.out.println(stack.isEmpty()? 1 : 0);
            } else if (order.equals("top")) {
                System.out.println(stack.isEmpty()? -1 : stack.peek());
            }
        }
    }
}
