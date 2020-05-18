package Java.Y2020.BOJ;

import java.io.*;
import java.util.*;

public class N13460 {
    static int n, m;
    static int rx, ry, bx, by;
    static int[][] arr;
    static boolean[][][][] visited;
    static Queue<Pair> q = new LinkedList<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        m = in.nextInt();

        arr = new int[n + 1][m + 1];
        visited = new boolean[n + 1][m + 1][n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            String s = in.next();

            for (int j = 1; j <= m; j++) {
                int data = 0;

                if (s.charAt(j - 1) == '.') {
                    data = 0;
                } else if (s.charAt(j - 1) == '#') {
                    data = -1;
                } else if (s.charAt(j - 1) == 'R') {
                    data = 1;
                    rx = i;
                    ry = j;
                } else if (s.charAt(j - 1) == 'B') {
                    data = 2;
                    bx = i;
                    by = j;
                } else if (s.charAt(j - 1) == 'O') {
                    data = 3;
                }

                arr[i][j] = data;
            }
        }

        System.out.println(bfs());
    }

    static int bfs() {
        q.offer(new Pair(rx, ry, bx, by, 0));
        visited[rx][ry][bx][by] = true;

        while (!q.isEmpty()) {
            Pair p = q.poll();

            if (p.count > 10) continue;
            if (arr[p.bx][p.by] == 3) continue;
            if (arr[p.rx][p.ry] == 3) return p.count;

            for (int i = 0; i < 4; i++) {
                // red
                int next_rx = p.rx;
                int next_ry = p.ry;

                while (true) {
                    if (arr[next_rx][next_ry] != -1 && arr[next_rx][next_ry] != 3) {
                        next_rx += dx[i];
                        next_ry += dy[i];
                    } else {
                        if (arr[next_rx][next_ry] == -1) {
                            next_rx -= dx[i];
                            next_ry -= dy[i];
                        }

                        break;
                    }
                }

                // blue
                int next_bx = p.bx;
                int next_by = p.by;

                while (true) {
                    if (arr[next_bx][next_by] != -1 && arr[next_bx][next_by] != 3) {
                        next_bx += dx[i];
                        next_by += dy[i];
                    } else {
                        if (arr[next_bx][next_by] == -1) {
                            next_bx -= dx[i];
                            next_by -= dy[i];
                        }

                        break;
                    }
                }

                // red와 blue는 같은 곳에 있을 수 없음
                if (next_rx == next_bx && next_ry == next_by) {
                    if (arr[next_rx][next_ry] != 3) {
                        int red_cost = Math.abs(next_rx - p.rx) + Math.abs(next_ry - p.ry);
                        int blue_cost = Math.abs(next_bx - p.bx) + Math.abs(next_by - p.by);

                        if (red_cost > blue_cost) {
                            next_rx -= dx[i];
                            next_ry -= dy[i];
                        } else {
                            next_bx -= dx[i];
                            next_by -= dy[i];
                        }
                    }
                }

                if (!visited[next_rx][next_ry][next_bx][next_by]) {
                    q.offer(new Pair(next_rx, next_ry, next_bx, next_by, p.count + 1));
                    visited[next_rx][next_ry][next_bx][next_by] = true;
                }
            }
        }

        return -1;
    }

    static class Pair {
        int rx, ry, bx, by, count;

        public Pair(int rx, int ry, int bx, int by, int count) {
            this.rx = rx;
            this.ry = ry;
            this.bx = bx;
            this.by = by;
            this.count = count;
        }
    }
}
