package Java.Y2020.BOJ;

import java.io.*;
import java.util.*;

public class N9019 {
    static int a, b;
    static String[] answer;
    static boolean[] visited;
    static Queue<Integer> q;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bf.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            answer = new String[10000];
            visited = new boolean[10000];

            Arrays.fill(answer, "");

            q = new LinkedList<>();
            q.offer(a);
            visited[a] = true;

            while (!q.isEmpty() && !visited[b]) {
                int now = q.poll();

                /*if (now == b) {
                    break;
                }*/

                int d = (now * 2) % 10000;
                int s = (now == 0) ? 9999 : now - 1;
                int l = (now % 1000) * 10 + now / 1000;
                int r = (now % 10) * 1000 + now / 10;

                if (!visited[d]) {
                    q.offer(d);
                    visited[d] = true;
                    answer[d] = answer[now] + "D";
                }

                if (!visited[s]) {
                    q.offer(s);
                    visited[s] = true;
                    answer[s] = answer[now] + "S";
                }

                if (!visited[l]) {
                    q.offer(l);
                    visited[l] = true;
                    answer[l] = answer[now] + "L";
                }

                if (!visited[r]) {
                    q.offer(r);
                    visited[r] = true;
                    answer[r] = answer[now] + "R";
                }
            }

            System.out.println(answer[b]);
        }
    }
}
