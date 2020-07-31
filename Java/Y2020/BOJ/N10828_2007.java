package Java.Y2020.BOJ;

import java.io.*;
import java.util.*;

public class N10828_2007 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        Stack<Integer> stack = new Stack<>();

        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            String order = bf.readLine();

            if (order.startsWith("pop")) {
                sb.append(stack.isEmpty()? -1 : stack.pop()).append("\n");
            } else if (order.startsWith("size")) {
                sb.append(stack.size()).append("\n");
            } else if (order.startsWith("empty")) {
                sb.append(stack.isEmpty()? 1 : 0).append("\n");
            } else if (order.startsWith("top")) {
                sb.append(stack.isEmpty()? -1 : stack.peek()).append("\n");
            } else {
                String[] arr = order.split(" ");
                int data = Integer.parseInt(arr[1]);
                stack.push(data);
            }
        }

        System.out.println(sb);
    }
}