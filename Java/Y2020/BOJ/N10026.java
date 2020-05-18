package Java.Y2020.BOJ;

import java.io.*;
import java.util.*;

public class N10026 {
    static int n;
    static int[][] arr;
    static int[][] arr2;
    static boolean[][] visited;
    static Queue<Pair> q;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(bf.readLine());

        arr = new int[n][n];
        arr2 = new int[n][n];

        for (int i = 0; i < n; i++) {
            String s = bf.readLine();

            for (int j = 0; j < n; j++) {
                char data = s.charAt(j);

                if (data == 'R') {
                    arr[i][j] = 1;
                    arr2[i][j] = 1;
                } else if (data == 'G') {
                    arr[i][j] = 2;
                    arr2[i][j] = 1;
                } else if (data == 'B') {
                    arr[i][j] = 3;
                    arr2[i][j] = 3;
                }
            }
        }

        //적록색약 아닌 사람
        visited = new boolean[n][n];

        int nCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] == false) {
                    nCount++;
                    bfs(i, j, arr[i][j]);
                }
            }
        }

        //적록색약
        visited = new boolean[n][n];

        int yCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] == false) {
                    yCount++;
                    bfs2(i, j, arr2[i][j]);
                }
            }
        }

        System.out.println(nCount + " " + yCount);
    }

    static void bfs(int x, int y, int color) {
        q = new LinkedList<>();
        q.offer(new Pair(x, y, color));
        visited[x][y] = true;

        while (!q.isEmpty()) {
            Pair p = q.poll();
            int tx = p.x;
            int ty = p.y;
            int tcolor = p.color;

            for (int i = 0; i < 4; i++) {
                int nx = tx + dx[i];
                int ny = ty + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    if (visited[nx][ny] == false && arr[nx][ny] == tcolor) {
                        q.offer(new Pair(nx, ny, tcolor));
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }

    static void bfs2(int x, int y, int color) {
        q = new LinkedList<>();
        q.offer(new Pair(x, y, color));
        visited[x][y] = true;

        while (!q.isEmpty()) {
            Pair p = q.poll();
            int tx = p.x;
            int ty = p.y;
            int tcolor = p.color;

            for (int i = 0; i < 4; i++) {
                int nx = tx + dx[i];
                int ny = ty + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    if (visited[nx][ny] == false && arr2[nx][ny] == tcolor) {
                        q.offer(new Pair(nx, ny, tcolor));
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }

    static class Pair {
        int x, y, color;

        public Pair(int x, int y, int color) {
            this.x = x;
            this.y = y;
            this.color = color;
        }
    }
}
