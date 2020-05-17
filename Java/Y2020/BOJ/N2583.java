package Java.Y2020.BOJ;

import java.io.*;
import java.util.*;

public class N2583 {
    static int m, n, k;
    static int[][] arr;
    static boolean[][] visited;
    static Queue<Pair> q = new LinkedList<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[m][n];
        visited = new boolean[m][n];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(bf.readLine());

            int bottomL = Integer.parseInt(st.nextToken());
            int bottomR = Integer.parseInt(st.nextToken());
            int topL = Integer.parseInt(st.nextToken());
            int topR = Integer.parseInt(st.nextToken());

            int fixedL = topR - 1;
            int fixedR = topL - 1;

            for (int a = bottomR; a <= fixedL; a++) {
                for (int b = bottomL; b <= fixedR; b++) {
                    arr[a][b] = 1;
                }
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] != 1 && visited[i][j] == false) {
                    count = 0;
                    bfs(i, j);
                    list.add(count);
                }
            }
        }

        Collections.sort(list);

        System.out.println(list.size());
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }

    static void bfs(int x, int y) {
        q.offer(new Pair(x, y));
        visited[x][y] = true;
        count++;

        while (!q.isEmpty()) {
            Pair p = q.poll();
            int tx = p.x;
            int ty = p.y;

            for (int i = 0; i < 4; i++) {
                int nx = tx + dx[i];
                int ny = ty + dy[i];

                if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                    if (arr[nx][ny] != 1 && visited[nx][ny] == false) {
                        q.offer(new Pair(nx, ny));
                        visited[nx][ny] = true;
                        count++;
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
