package Java.Y2019.BOJ.queue;

import java.util.*;

public class N10866 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            String str = in.next();

            if (str.equals("push_front")) {
                int data = in.nextInt();
                deque.offerFirst(data);
            }

            else if (str.equals("push_back")) {
                int data2 = in.nextInt();
                deque.offerLast(data2);
            }

            else if (str.equals("pop_front")) {
                if (deque.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(deque.pollFirst());
                }
            }

            else if (str.equals("pop_back")) {
                if (deque.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(deque.pollLast());
                }
            }

            else if (str.equals("size")) {
                System.out.println(deque.size());
            }

            else if (str.equals("empty")) {
                if (deque.isEmpty()) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            }

            else if (str.equals("front")) {
                if (deque.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(deque.peekFirst());
                }
            }

            else if (str.equals("back")) {
                if (deque.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(deque.peekLast());
                }
            }
        }
    }
}
