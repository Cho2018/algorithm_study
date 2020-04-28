package Java.Y2019.BOJ.graph;

import java.util.*;

public class N1012 {
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int M, N, K;
    static int count;
    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();

        while (T-- != 0) {
            list.clear();

            M = in.nextInt();
            N = in.nextInt();
            K = in.nextInt();

            graph = new int[M][N];
            while (K-- != 0) {
                int x = in.nextInt();
                int y = in.nextInt();

                graph[x][y] = 1;
            }

            visited = new boolean[M][N];
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (graph[i][j] == 1 && visited[i][j] == false) {
                        count = 1;
                        dfs(i, j);
                        list.add(count);
                    }
                }
            }

            System.out.println(list.size());
        }
    }

    static int dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < M && ny >= 0 && ny < N) {
                if (graph[nx][ny] == 1 && visited[nx][ny] == false) {
                    count++;
                    dfs(nx, ny);
                }
            }
        }

        return count;
    }
}
