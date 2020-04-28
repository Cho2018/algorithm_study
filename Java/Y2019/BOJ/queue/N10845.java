package Java.Y2019.BOJ.queue;

import java.util.*;

public class N10845 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        int data = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            String str = in.next();

            if (str.equals("pop")) {
                if (queue.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(queue.poll());
                }
            }

            else if (str.equals("push")) {
                data = in.nextInt();
                queue.offer(data);
            }

            else if (str.equals("size")) {
                System.out.println(queue.size());
            }

            else if (str.equals("empty")) {
                if (queue.isEmpty()) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            }

            else if (str.equals("front")) {
                if (queue.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(queue.peek());
                }
            }

            else if (str.equals("back")) {
                if (queue.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(data);
                }
            }
        }
    }
}
