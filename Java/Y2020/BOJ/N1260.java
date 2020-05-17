package Java.Y2020.BOJ;

import java.io.*;
import java.util.*;

public class N1260 {
    static int n, m, v;
    static int[][] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        arr = new int[n + 1][n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[x][y] = arr[y][x] = 1;
        }

        dfs(v);

        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }
        System.out.println();

        bfs(v);
    }

    static void dfs(int v) {
        visited[v] = true;
        System.out.print(v + " ");

        for (int i = 1; i <= n; i++) {
            if (arr[v][i] == 1 && visited[i] == false) {
                dfs(i);
            }
        }
    }

    static void bfs(int v) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(v);
        visited[v] = true;
        System.out.print(v + " ");

        while (!q.isEmpty()) {
            int temp = q.poll();

            for (int i = 1; i <= n; i++) {
                if (arr[temp][i] == 1 && visited[i] == false) {
                    q.offer(i);
                    visited[i] = true;
                    System.out.print(i + " ");
                }
            }
        }
    }
}
