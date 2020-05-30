package Java.Y2020.BOJ;

import java.io.*;
import java.util.*;

public class N5014 {
    static int f, s, g, u, d;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        f = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        u = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        arr = new int[f + 1];

        System.out.println(bfs());
    }

    static String bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(s);
        arr[s] = 1;

        while (!q.isEmpty()) {
            int now = q.poll();

            if (now == g) {
                return String.valueOf(arr[now] - 1);
            }

            if (now + u <= f) {
                if (arr[now + u] == 0) {
                    q.offer(now + u);
                    arr[now + u] = arr[now] + 1;
                }

            }

            if (now - d > 0) {
                if (arr[now - d] == 0) {
                    q.offer(now - d);
                    arr[now - d] = arr[now] + 1;
                }
            }
        }

        return "use the stairs";
    }
}
