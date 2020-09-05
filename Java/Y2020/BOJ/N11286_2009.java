package Java.Y2020.BOJ;

import java.io.*;
import java.util.*;

public class N11286_2009 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        Queue<Integer> queue = new PriorityQueue<>(((o1, o2) -> {
            int abs1 = Math.abs(o1);
            int abs2 = Math.abs(o2);

            if (abs1 == abs2) return o1 > o2? 1 : -1;
            else return abs1 - abs2;
        }));

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
