package Java.Y2020.BOJ;

import java.io.*;
import java.util.*;

public class N10845_2007 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        Queue<Integer> queue = new LinkedList<>();

        int data = 0;
        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            String order = bf.readLine();

            if (order.startsWith("pop")) {
                sb.append(queue.isEmpty()? -1 : queue.poll()).append("\n");
            } else if (order.startsWith("size")) {
                sb.append(queue.size()).append("\n");
            } else if (order.startsWith("empty")) {
                sb.append(queue.isEmpty()? 1 : 0).append("\n");
            } else if (order.startsWith("front")) {
                sb.append(queue.isEmpty()? -1 : queue.peek()).append("\n");
            } else if (order.startsWith("push")) {
                String[] arr = order.split(" ");
                data = Integer.parseInt(arr[1]);
                queue.offer(data);
            } else {
                sb.append(queue.isEmpty()? -1 : data).append("\n");
            }
        }

        System.out.println(sb);
    }
}
