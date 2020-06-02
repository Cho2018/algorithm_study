package Java.Y2020.BOJ;

import java.io.*;
import java.util.*;

public class N1600 {
    static int k;
    static int w, h;
    static int[][] arr;
    static boolean[][][] visited;
    static Queue<Pair> q = new LinkedList<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[] hdx = {-2, -2, 2, 2, 1, -1, 1, -1};
    static int[] hdy = {1, -1, 1, -1, 2, 2, -2, -2};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        k = Integer.parseInt(bf.readLine());

        StringTokenizer st = new StringTokenizer(bf.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        arr = new int[h][w];
        visited = new boolean[h][w][31];

        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(bf.readLine());

            for (int j = 0; j < w; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs();
    }

    static void bfs() {
        q.offer(new Pair(0, 0, 0, k));
        visited[0][0][0] = true;

        while (!q.isEmpty()) {
            Pair p = q.poll();
            int tx = p.x;
            int ty = p.y;
            int tcount = p.count;
            int tk = p.k;

            if (tx == h - 1 && ty == w - 1) {
                System.out.println(tcount);
                return;
            }

            if (tx >= h || ty >= w || tx < 0 || ty < 0) continue;

            if (arr[tx][ty] == 1) continue;
            if (visited[tx][ty][tk]) continue;

            visited[tx][ty][tk] = true;

            for (int i = 0; i < 4; i++) {
                int nx = tx + dx[i];
                int ny = ty + dy[i];

                q.offer(new Pair(nx, ny, tcount + 1, tk));
            }

            if (tk == 0) continue;

            for (int i = 0; i < 8; i++) {
                int nx = tx + hdx[i];
                int ny = ty + hdy[i];

                q.offer(new Pair(nx, ny, tcount + 1, tk - 1));
            }
        }

        System.out.println(-1);
        return;
    }

    static class Pair {
        int x, y;
        int count;
        int k;

        public Pair(int x, int y, int count, int k) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.k = k;
        }
    }
}
