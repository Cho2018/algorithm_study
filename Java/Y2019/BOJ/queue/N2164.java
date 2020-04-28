package Java.Y2019.BOJ.queue;

import java.util.*;

public class N2164 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }

        int data = 0;
        while (queue.size() > 1) {
            queue.poll();
            data = queue.peek();
            queue.poll();
            queue.offer(data);
        }

        System.out.println(queue.peek());
    }
}
