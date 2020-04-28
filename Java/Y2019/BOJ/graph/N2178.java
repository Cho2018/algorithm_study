package Java.Y2019.BOJ.graph;

import java.util.*;

public class N2178 {
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N, M;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        M = in.nextInt();

        graph = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String str = in.next();

            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(str.charAt(j) + "");
            }
        }

        bfs(0, 0);
        System.out.println(graph[N - 1][M - 1]);
    }

    static void bfs(int x, int y) {
        Queue<Integer> qx = new LinkedList<>();
        Queue<Integer> qy = new LinkedList<>();

        qx.offer(x);
        qy.offer(y);

        visited[x][y] = true;

        int tx, ty;
        while (!qx.isEmpty() && !qy.isEmpty()) {
            tx = qx.poll();
            ty = qy.poll();

            for (int i = 0; i < 4; i++) {
                int nx = tx + dx[i];
                int ny = ty + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (graph[nx][ny] == 1 && visited[nx][ny] == false) {
                        qx.offer(nx);
                        qy.offer(ny);
                        visited[nx][ny] = true;
                        graph[nx][ny] = graph[tx][ty] + 1; //방문한 좌표는 이동 횟수로 변경
                    }
                }
            }
        }
    }
}
