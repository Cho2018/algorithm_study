package Java.Y2020.BOJ;

import java.io.*;
import java.util.*;

public class N1715_2009 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        Queue<Integer> queue = new PriorityQueue<>(Comparator.naturalOrder());

        for (int i = 0; i < n; i++) {
            int data = Integer.parseInt(bf.readLine());
            queue.offer(data);
        }

        int answer = 0;
        while (queue.size() != 1) {
            int re_data = queue.poll() + queue.poll();
            answer += re_data;
            queue.offer(re_data);
        }

        System.out.println(answer);
    }
}
