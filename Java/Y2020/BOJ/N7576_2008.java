package Java.Y2020.BOJ;

import java.io.*;
import java.util.*;

public class N7576_2008 {
    static int m, n;
    static int[][] arr;
    static boolean[][] visited;
    static Queue<Pair> queue = new LinkedList<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int answer = 0;

    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void ft_bfs() {
        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            int tx = p.x;
            int ty = p.y;

            for (int i = 0; i < 4; i++) {
                int nx = tx + dx[i];
                int ny = ty + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (arr[nx][ny] == 0 && visited[nx][ny] == false) {
                        queue.offer(new Pair(nx, ny));
                        visited[nx][ny] = true;
                        arr[nx][ny] = arr[tx][ty] + 1;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());

            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 1 : 익은 토마토
        // 0 : 익지 않은 토마토
        // -1 : 토마토 x
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1) {
                    queue.offer(new Pair(i, j));
                    visited[i][j] = true;
                }
            }
        }

        ft_bfs();

        int max = 0;
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) {
                    flag = true;
                    break;
                } else {
                    max = Math.max(max, arr[i][j]);
                    answer = max - 1;
                }
            }
        }

        if (flag == true) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }
}
