package Java.Y2020.BOJ;

import java.io.*;
import java.util.*;

public class N10866 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        Deque<Integer> deque = new LinkedList<>();

        while (n-- > 0) {
            String order = in.next();

            if (order.equals("push_front")) {
                int data = in.nextInt();

                deque.offerFirst(data);
            } else if (order.equals("push_back")) {
                int data = in.nextInt();

                deque.offerLast(data);
            } else if (order.equals("pop_front")) {
                System.out.println(deque.isEmpty()? -1 : deque.pollFirst());
            } else if (order.equals("pop_back")) {
                System.out.println(deque.isEmpty()? -1 : deque.pollLast());
            } else if (order.equals("size")) {
                System.out.println(deque.size());
            } else if (order.equals("empty")) {
                System.out.println(deque.isEmpty()? 1 : 0);
            } else if (order.equals("front")) {
                System.out.println(deque.isEmpty()? -1 : deque.peekFirst());
            } else if (order.equals("back")) {
                System.out.println(deque.isEmpty()? -1 : deque.peekLast());
            }
        }
    }
}
