package Java.Y2020.BOJ;

import java.io.*;
import java.util.*;

public class N2606_2008 {
    static int n, m;
    static int[][] arr;
    static boolean[] visited;
    static int count = 0;

    static void ft_bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);
        visited[v] = true;

        while (!queue.isEmpty()) {
            int temp = queue.poll();

            for (int i = 1; i <= n; i++) {
                if (arr[temp][i] == 1 && visited[i] == false) {
                    queue.offer(i);
                    visited[i] = true;
                    count++;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(bf.readLine());
        m = Integer.parseInt(bf.readLine());

        arr = new int[n + 1][n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[x][y] = arr[y][x] = 1;
        }

        ft_bfs(1);

        System.out.println(count);
    }
}
