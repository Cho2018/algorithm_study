package Java.Y2020.BOJ;

import java.io.*;
import java.util.*;

public class N1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Deque<Integer> deque = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            deque.offer(i);
        }

        StringBuilder sb = new StringBuilder("<");
        while (!deque.isEmpty()) {
            for (int i = 0; i < k - 1; i++) {
                deque.offerLast(deque.poll());
            }

            sb.append(deque.poll() + ", ");
        }

        System.out.println(sb.toString().substring(0, sb.length() - 2) + ">");
    }
}
