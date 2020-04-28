package Java.Y2019.BOJ.graph;

import java.util.*;

public class N2606 {
    static int[][] graph;
    static boolean[] visited;
    static int n, m, s, count;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();

        graph = new int[n + 1][n + 1];
        visited = new boolean[n + 1];

        while (m-- != 0) {
            int x = in.nextInt();
            int y = in.nextInt();

            graph[x][y] = graph[y][x] = 1;
        }

        s = 1;

        System.out.println(dfs(s) - 1);
    }

    static int dfs(int v) {
        visited[v] = true;
        count++;

        for (int j = 1; j <= n; j++) {
            if (graph[v][j] == 1 && visited[j] == false) dfs(j);
        }

        return count;
    }
}
