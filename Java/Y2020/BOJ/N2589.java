package Java.Y2020.BOJ;

import java.io.*;
import java.util.*;

public class N2589 {
    static int n, m;
    static char[][] arr;
    static boolean[][] visited;
    static Queue<Pair> q;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] distance;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new char[n][m];

        for (int i = 0; i < n; i++) {
            String s = bf.readLine();

            for (int j = 0; j < m; j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 'L') {
                    bfs(i, j);
                }
            }
        }

        System.out.println(answer);
    }

    static void bfs(int x, int y) {
        q = new LinkedList<>();
        visited = new boolean[n][m];
        distance = new int[n][m];

        q.offer(new Pair(x, y));
        visited[x][y] = true;

        int temp = 0;
        while (!q.isEmpty()) {
            Pair p = q.poll();
            int tx = p.x;
            int ty = p.y;

            for (int i = 0; i < 4; i++) {
                int nx = tx + dx[i];
                int ny = ty + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (arr[nx][ny] == 'L' && visited[nx][ny] == false) {
                        q.offer(new Pair(nx, ny));
                        visited[nx][ny] = true;

                        distance[nx][ny] = distance[tx][ty] + 1;

                        if (temp < distance[nx][ny]) {
                            temp = distance[nx][ny];
                        }
                    }
                }
            }
        }

        if (answer < temp) {
            answer = temp;
        }
    }

    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
