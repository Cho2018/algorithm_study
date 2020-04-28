package Java.Y2019.BOJ.graph;

import java.util.*;

public class N7576 {
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int M, N;
    static int result;
    static Queue<Integer> qx = new LinkedList<>();
    static Queue<Integer> qy = new LinkedList<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        M = in.nextInt();
        N = in.nextInt();

        visited = new boolean[N][M];
        graph = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                graph[i][j] = in.nextInt();

                if (graph[i][j] == 1) {
                    qx.offer(i);
                    qy.offer(j);
                }
            }
            in.nextLine();
        }

        bfs();
    }

    static void bfs() {
        result = 0;

        int tx, ty;
        while (!qx.isEmpty() && !qy.isEmpty()) {
            tx = qx.poll();
            ty = qy.poll();

            for (int i = 0; i < 4; i++) {
                int nx = tx + dx[i];
                int ny = ty + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (graph[nx][ny] == 0 && visited[nx][ny] == false) {
                        qx.offer(nx);
                        qy.offer(ny);
                        visited[nx][ny] = true;
                        graph[nx][ny] = graph[tx][ty] + 1;
                        result = graph[nx][ny];
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (graph[i][j] == 0) {
                    result = -1;
                }
            }
        }

        if (result > 0) {
            System.out.println(result - 1);
        } else {
            System.out.println(result);
        }
    }
}
