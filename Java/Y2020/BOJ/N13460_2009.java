package Java.Y2020.BOJ;

import java.io.*;
import java.util.*;

public class N13460_2009 {
    static int n, m;
    static int[][] arr;
    static boolean[][][][] visited;
    static Queue<Pair> queue = new LinkedList<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int r_x, r_y, b_x, b_y;

    static class Pair {
        int r_x, r_y, b_x, b_y, count;

        public Pair(int r_x, int r_y, int b_x, int b_y, int count) {
            this.r_x = r_x;
            this.r_y = r_y;
            this.b_x = b_x;
            this.b_y = b_y;
            this.count = count;
        }
    }

    static int ft_bfs() {
        queue.offer(new Pair(r_x, r_y, b_x, b_y, 0));
        visited[r_x][r_y][b_x][b_y] = true;

        while (!queue.isEmpty()) {
            Pair p = queue.poll();

            if (p.count > 10) break;
            if (arr[p.b_x][p.b_y] == 7) continue;
            if (arr[p.r_x][p.r_y] == 7) return p.count;

            for (int i = 0; i < 4; i++) {
                int n_rx = p.r_x, n_ry = p.r_y;

                while (true) {
                    if (arr[n_rx][n_ry] != -1 && arr[n_rx][n_ry] != 7) {
                        n_rx += dx[i];
                        n_ry += dy[i];
                    } else {
                        if (arr[n_rx][n_ry] == -1) {
                            n_rx -= dx[i];
                            n_ry -= dy[i];
                        }

                        break;
                    }
                }

                int n_bx = p.b_x, n_by = p.b_y;

                while (true) {
                    if (arr[n_bx][n_by] != -1 && arr[n_bx][n_by] != 7) {
                        n_bx += dx[i];
                        n_by += dy[i];
                    } else {
                        if (arr[n_bx][n_by] == -1) {
                            n_bx -= dx[i];
                            n_by -= dy[i];
                        }

                        break;
                    }
                }

                int r_cost = 0, b_cost = 0;
                if (n_rx == n_bx && n_ry == n_by) {
                    if (arr[n_rx][n_ry] != 7) {
                        r_cost = Math.abs(n_rx - p.r_x) + Math.abs(n_ry - p.r_y);
                        b_cost = Math.abs(n_bx - p.b_x) + Math.abs(n_by - p.b_y);

                        if (r_cost > b_cost) {
                            n_rx -= dx[i];
                            n_ry -= dy[i];
                        } else {
                            n_bx -= dx[i];
                            n_by -= dy[i];
                        }
                    }
                }

                if (!visited[n_rx][n_ry][n_bx][n_by]) {
                    queue.offer(new Pair(n_rx, n_ry, n_bx, n_by, p.count + 1));
                    visited[n_rx][n_ry][n_bx][n_by] = true;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n + 1][m + 1];
        visited = new boolean[n + 1][m + 1][n + 1][m + 1];

        for (int i = 1; i < n + 1; i++) {
            String s = bf.readLine();

            for (int j = 1; j < m + 1; j++) {
                char temp = s.charAt(j - 1);
                int data = 0;

                switch (temp) {
                    case '#' :
                        data = -1;
                        break;
                    case '.' :
                        data = 0;
                        break;
                    case 'R' :
                        data = 1;
                        r_x = i;
                        r_y = j;
                        break;
                    case 'B' :
                        data = 2;
                        b_x = i;
                        b_y = j;
                        break;
                    case 'O' :
                        data = 7;
                        break;
                }

                arr[i][j] = data;
            }
        }

        System.out.println(ft_bfs());
    }
}
