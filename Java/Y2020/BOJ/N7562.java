package Java.Y2020.BOJ;

import java.io.*;
import java.util.*;

public class N7562 {
    static int l;
    static int nowX, nowY, desX, desY;
    static int[][] arr;
    static boolean[][] visited;
    static Queue<Pair> q;
    static int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bf.readLine());
        while (t-- > 0) {
            l = Integer.parseInt(bf.readLine());

            arr = new int[l][l];
            visited = new boolean[l][l];

            StringTokenizer st = new StringTokenizer(bf.readLine());
            nowX = Integer.parseInt(st.nextToken());
            nowY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(bf.readLine());
            desX = Integer.parseInt(st.nextToken());
            desY = Integer.parseInt(st.nextToken());

            count = 0;
            bfs(nowX, nowY);

            System.out.println(count);
        }
    }

    static void bfs(int x, int y) {
        if (x == desX && y == desY) {
            count = 0;
            return;
        }

        q = new LinkedList<>();
        q.offer(new Pair(x, y));
        visited[x][y] = true;

        while(!q.isEmpty()) {
            Pair p = q.poll();
            int tx = p.x;
            int ty = p.y;

            for (int i = 0; i < 8; i++) {
                int nx = tx + dx[i];
                int ny = ty + dy[i];

                if (nx >= 0 && nx < l && ny >= 0 && ny < l) {
                    if (visited[nx][ny] == false) {
                        q.offer(new Pair(nx, ny));
                        visited[nx][ny] = true;
                        arr[nx][ny] = arr[tx][ty] + 1;

                        if (desX == nx && desY == ny) {
                            count = arr[nx][ny];
                            return;
                        }
                    }
                }
            }
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
