package Java.Y2020.BOJ;

import java.io.*;
import java.util.*;

public class N11724 {
    static int n, m;
    static int[][] arr;
    static boolean[] visited;
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n + 1][n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[x][y] = arr[y][x] = 1;
        }

        int count = 0;
        for (int i = 1; i < n + 1; i++) {
            if (visited[i] == false) {
                count++;
                bfs(i);
            }
        }

        System.out.println(count);
    }

    static void bfs(int x) {
        q.offer(x);
        visited[x] = true;

        while (!q.isEmpty()) {
            int temp = q.poll();

            for (int i = 1; i < n + 1; i++) {
                if (arr[temp][i] == 1 && visited[i] == false) {
                    q.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}
