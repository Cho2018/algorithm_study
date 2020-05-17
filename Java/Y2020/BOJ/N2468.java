package Java.Y2020.BOJ;

import java.io.*;
import java.util.*;

public class N2468 {
    static int n;
    static int[][] arr;
    static int[][] copy;
    static boolean[][] visited;
    static Queue<Pair> q = new LinkedList<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(bf.readLine());

        arr = new int[n][n];
        copy = new int[n][n];

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());

            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                list.add(arr[i][j]);
            }
        }

        int maxCount = Collections.max(list);

        int count;
        int max = 0;
        for (int i = 0; i <= maxCount; i++) {
            init();
            water(i);

            count = 0;
            for (int a = 0; a < n; a++) {
                for (int b = 0; b < n; b++) {
                    if (copy[a][b] != -1 && visited[a][b] == false) {
                        count++;
                        bfs(a, b);
                    }
                }
            }

            max = Math.max(max, count);
        }

        System.out.println(max);
    }

    static void init() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                copy[i][j] = arr[i][j];
            }
        }

        visited = new boolean[n][n];
    }

    static void water(int cen) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (copy[i][j] <= cen) {
                    copy[i][j] = -1;
                }
            }
        }
    }

    static void bfs(int x, int y) {
        q.offer(new Pair(x, y));
        visited[x][y] = true;

        while (!q.isEmpty()) {
            Pair p = q.poll();
            int tx = p.x;
            int ty = p.y;

            for (int i = 0; i < 4; i++) {
                int nx = tx + dx[i];
                int ny = ty + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    if (copy[nx][ny] != -1 && visited[nx][ny] == false) {
                        q.offer(new Pair(nx, ny));
                        visited[nx][ny] = true;
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
