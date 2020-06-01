package Java.Y2020.BOJ;

import java.io.*;
import java.util.*;

public class N1325_time {
    static int n, m;
    static int[][] arr;
    static boolean[] visited;
    static Queue<Integer> q = new LinkedList<>();
    static int count;
    static int[] answer = new int[10001];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n + 1][n + 1];

        while (m-- > 0) {
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[y][x] = 1;
        }

        for (int i = 1; i <= n; i++) {
            bfs(i);
        }

        int max = 0;
        for (int i = 0; i < answer.length; i++) {
            if (max < answer[i]) {
                max = answer[i];
            }
        }

        for (int i = 0; i < answer.length; i++) {
            if (max == answer[i]) {
                System.out.print(i + " ");
            }
        }
    }

    static void bfs(int start) {
        count = 0;
        visited = new boolean[n + 1];

        q.offer(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int now = q.poll();

            for (int i = 1; i <= n; i++) {
                if (arr[now][i] == 1 && visited[i] == false) {
                    count++;
                    q.offer(i);
                    visited[i] = true;
                }
            }
        }

        answer[start] = count;
    }
}
