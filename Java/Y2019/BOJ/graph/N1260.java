package Java.Y2019.BOJ.graph;

import java.util.*;

//DFS - 스택 / 재귀함수(가장 보편)
//BFS - Queue
public class N1260 {
    static int[][] graph;
    static boolean[] visited;
    static int N, M, V;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        M = in.nextInt();
        V = in.nextInt();

        graph = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        while (M-- != 0) {
            int x = in.nextInt();
            int y = in.nextInt();

            graph[x][y] = graph[y][x] = 1;
        }

        dfs(V);

        for (int i = 1; i <= N; i++) {
            visited[i] = false;
        }
        System.out.println();

        bfs(V);
    }

    static void dfs(int V1) {
        visited[V1] = true;
        System.out.print(V1 + " ");

        for (int j = 1; j <= N; j++) {
            if (graph[V1][j] == 1 && visited[j] == false) dfs(j);
        }
    }

    static void bfs(int V1) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(V1);
        visited[V1] = true;
        System.out.print(V1 + " ");

        int temp;
        while (!queue.isEmpty()) {
            temp = queue.poll();

            for (int j = 1; j <= N; j++) {
                if (graph[temp][j] == 1 && visited[j] == false) {
                    queue.offer(j);
                    visited[j] = true;
                    System.out.print(j + " ");
                }
            }
        }
    }
}
