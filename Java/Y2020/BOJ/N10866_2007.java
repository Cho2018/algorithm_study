package Java.Y2020.BOJ;

import java.io.*;
import java.util.*;

public class N10866_2007 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        Deque<Integer> deque = new LinkedList<>();

        int data = 0;
        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            String order = bf.readLine();

            if (order.startsWith("pop_front")) {
                sb.append(deque.isEmpty()? -1 : deque.pollFirst()).append("\n");
            } else if (order.startsWith("pop_back")) {
                sb.append(deque.isEmpty()? -1 : deque.pollLast()).append("\n");
            } else if (order.startsWith("size")) {
                sb.append(deque.size()).append("\n");
            } else if (order.startsWith("empty")) {
                sb.append(deque.isEmpty()? 1 : 0).append("\n");
            } else if (order.startsWith("front")) {
                sb.append(deque.isEmpty()? -1 : deque.peekFirst()).append("\n");
            } else if (order.startsWith("back")) {
                sb.append(deque.isEmpty()? -1 : deque.peekLast()).append("\n");
            } else if (order.startsWith("push_front")) {
                String[] arr = order.split(" ");
                data = Integer.parseInt(arr[1]);
                deque.offerFirst(data);
            } else {
                String[] arr = order.split(" ");
                data = Integer.parseInt(arr[1]);
                deque.offerLast(data);
            }
        }

        System.out.println(sb);
    }
}
