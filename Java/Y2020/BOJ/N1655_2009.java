package Java.Y2020.BOJ;

import java.io.*;
import java.util.*;

public class N1655_2009 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        Queue<Integer> min_queue = new PriorityQueue<>();
        Queue<Integer> max_queue = new PriorityQueue<>((o1, o2) -> o2 - o1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int data = Integer.parseInt(bf.readLine());

            if (min_queue.size() == max_queue.size()) max_queue.offer(data);
            else min_queue.offer(data);

            if (!min_queue.isEmpty() && !max_queue.isEmpty()) {
                if (min_queue.peek() < max_queue.peek()) {
                    int temp = min_queue.poll();
                    min_queue.offer(max_queue.poll());
                    max_queue.offer(temp);
                }
            }

            sb.append(max_queue.peek()).append("\n");
        }

        System.out.println(sb);
    }
}
