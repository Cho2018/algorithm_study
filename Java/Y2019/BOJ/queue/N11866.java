package Java.Y2019.BOJ.queue;

import java.util.*;

public class N11866 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int K = in.nextInt();

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }

        String str = "";
        while (!queue.isEmpty()) {
            for (int i = 0; i < K - 1; i++) {
                int data = queue.poll();
                queue.offer(data);
            }

            str += queue.poll() + ", ";
        }

        System.out.println("<" + str.substring(0, str.length() - 2) + ">");
    }
}
