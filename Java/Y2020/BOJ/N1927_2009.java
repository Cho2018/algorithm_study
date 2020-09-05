package Java.Y2020.BOJ;

import java.io.*;
import java.util.*;

public class N1927_2009 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        Queue<Integer> queue = new PriorityQueue<>(Comparator.naturalOrder());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int data = Integer.parseInt(bf.readLine());

            if (data == 0) {
                if (queue.isEmpty()) sb.append("0").append("\n");
                else sb.append(queue.poll()).append("\n");
            } else {
                queue.offer(data);
            }
        }

        System.out.println(sb);
    }
}
