package Java.Y2020.BOJ;

import java.io.*;
import java.util.*;

public class N1726 {
    static int m, n;
    static int[][] arr;
    static boolean[][][] visited;
    static Queue<Pair> q;
    // 동 서 남 북
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static Pair start, end;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        arr = new int[101][101];
        visited = new boolean[101][101][5];

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(bf.readLine());

            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(bf.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int dir = Integer.parseInt(st.nextToken());

        start = new Pair(x, y, dir, 0);

        st = new StringTokenizer(bf.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        dir = Integer.parseInt(st.nextToken());

        end = new Pair(x, y, dir, 0);

        bfs();
    }

    static void bfs() {
        q = new LinkedList<>();

        q.offer(start);
        visited[start.x][start.y][start.dir] = true;

        while (!q.isEmpty()) {
            Pair p = q.poll();

            if (p.x == end.x && p.y == end.y && p.dir == end.dir) {
                System.out.println(p.count);
                return;
            }

            // 명령 1
            for (int i = 1; i <= 3; i++) {
                int nx = p.x + dx[p.dir - 1] * i;
                int ny = p.y + dy[p.dir - 1] * i;

                if (nx >= 1 && nx <= m && ny >= 1 && ny <= n) {
                    if (arr[nx][ny] == 0) {
                        if (!visited[nx][ny][p.dir]) {
                            q.offer(new Pair(nx, ny, p.dir, p.count + 1));
                            visited[nx][ny][p.dir] = true;
                        }
                    } else {
                        break;
                    }
                }
            }

            // 명령 2
            for (int i = 1; i <= 4; i++) {
                if (p.dir != i && !visited[p.x][p.y][i]) {
                    visited[p.x][p.y][i] = true;

                    if ((p.dir == 1 && i == 2) || (p.dir == 2 && i == 1) || (p.dir == 3 && i == 4) || (p.dir == 4 && i == 3)) {
                        q.offer(new Pair(p.x, p.y, i, p.count + 2));
                    } else {
                        q.offer(new Pair(p.x, p.y, i, p.count + 1));
                    }
                }
            }
        }
    }

    static class Pair {
        int x, y;
        int dir;
        int count;

        public Pair(int x, int y, int dir, int count) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.count = count;
        }
    }
}

