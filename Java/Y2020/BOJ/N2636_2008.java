package Java.Y2020.BOJ;

import java.io.*;
import java.util.*;

public class N2636_2008 {
    static int row, col;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int time, count;

    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void ft_bfs() {
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(0, 0));

        while (!queue.isEmpty()) {
            Pair p = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx >= 0 && nx < row && ny >= 0 && ny < col && !visited[nx][ny]) {
                    if (arr[nx][ny] == 0) {
                        queue.offer(new Pair(nx, ny));
                        visited[nx][ny] = true;
                    } else {
                        arr[nx][ny] = 0;
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        arr = new int[row][col];

        int cheese_total = 0;
        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(bf.readLine());

            for (int j = 0; j < col; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                if (arr[i][j] == 1) {
                    cheese_total++;
                }
            }
        }

        while (true) {
            visited = new boolean[row][col];
            ft_bfs();

            time++;
            count = 0;
            boolean flag = true;

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (arr[i][j] != 0) {
                        flag = false;
                        count++;
                    }
                }
            }

            // 모든 치즈가 다 녹았다
            if (flag)
                break;

            cheese_total = count;
        }

        System.out.println(time);
        System.out.println(cheese_total);
    }
}
