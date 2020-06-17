package Java.Y2020.BOJ;

import java.io.*;
import java.util.*;

public class N10845 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        Queue<Integer> queue = new LinkedList<>();

        int data = 0;

        while (n-- > 0) {
            String order = in.next();

            if (order.equals("push")) {
                data = in.nextInt();

                queue.offer(data);
            } else if (order.equals("pop")) {
                System.out.println(queue.isEmpty()? -1 : queue.poll());
            } else if (order.equals("size")) {
                System.out.println(queue.size());
            } else if (order.equals("empty")) {
                System.out.println(queue.isEmpty()? 1 : 0);
            } else if (order.equals("front")) {
                System.out.println(queue.isEmpty()? -1 : queue.peek());
            } else if (order.equals("back")) {
                System.out.println(queue.isEmpty()? -1 : data);
            }
        }
    }
}
