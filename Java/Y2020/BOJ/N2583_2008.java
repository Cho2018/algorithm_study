package Java.Y2020.BOJ;

import java.io.*;
import java.util.*;

public class N2583_2008 {
    static int m, n, k;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int count;

    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void ft_bfs(int x, int y) {
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(x, y));
        visited[x][y] = true;
        count++;

        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            int tx = p.x;
            int ty = p.y;

            for (int i = 0; i < 4; i++) {
                int nx = tx + dx[i];
                int ny = ty + dy[i];

                if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                    if (arr[nx][ny] != 1 && visited[nx][ny] == false) {
                        queue.offer(new Pair(nx, ny));
                        visited[nx][ny] = true;
                        count++;
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
        k = Integer.parseInt(st.nextToken());

        arr = new int[m][n];
        visited = new boolean[m][n];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(bf.readLine());

            int left_bottom_x = Integer.parseInt(st.nextToken());
            int left_bottom_y = Integer.parseInt(st.nextToken());
            int right_top_x = Integer.parseInt(st.nextToken());
            int right_top_y = Integer.parseInt(st.nextToken());

            int fixed_y = right_top_y - 1;
            int fixed_x = right_top_x - 1;

            for (int a = left_bottom_y; a <= fixed_y; a++) {
                for (int b = left_bottom_x; b <= fixed_x; b++) {
                    arr[a][b] = 1;
                }
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] != 1 && visited[i][j] == false) {
                    count = 0;
                    ft_bfs(i, j);
                    list.add(count);
                }
            }
        }

        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        sb.append(list.size()).append("\n");

        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i)).append(" ");
        }

        System.out.println(sb);
    }
}
