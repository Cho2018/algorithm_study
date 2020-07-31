package Java.Y2020.BOJ;

import java.io.*;
import java.util.*;

public class N1406_2007 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        Stack left_stack = new Stack<>();
        Stack right_stack = new Stack<>();

        String string = bf.readLine();
        for (int i = 0; i < string.length(); i++) {
            left_stack.push(string.charAt(i));
        }

        int m = Integer.parseInt(bf.readLine());
        for (int i = 0; i < m; i++) {
            String order = bf.readLine();

            if (order.startsWith("L")) {
                if (!left_stack.isEmpty()) {
                    right_stack.push(left_stack.pop());
                }
            } else if (order.startsWith("D")) {
                if (!right_stack.isEmpty()) {
                    left_stack.push(right_stack.pop());
                }
            } else if (order.startsWith("B")) {
                if (!left_stack.isEmpty()) {
                    left_stack.pop();
                }
            } else if (order.startsWith("P")) {
                String[] arr = order.split(" ");
                left_stack.push(arr[1]);
            }
        }

        while (!left_stack.isEmpty()) {
            right_stack.push(left_stack.pop());
        }

        StringBuilder sb = new StringBuilder();
        while (!right_stack.isEmpty()) {
            sb.append(right_stack.pop());
        }

        System.out.println(sb);
    }
}
