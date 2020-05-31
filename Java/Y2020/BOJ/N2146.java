package Java.Y2020.BOJ;

import java.io.*;
import java.util.*;

public class N2146 {
    static int n;
    static int[][] arr;
    static int[][] group;
    static int[][] distance;
    static Queue<Pair> q = new LinkedList<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(bf.readLine());

        arr = new int[n][n];
        group = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());

            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 대륙 넘버링
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1 && group[i][j] == 0) {
                    grouping(i, j, ++count);
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 1; i <= count; i++) {
            answer = Math.min(answer, bfs(i));
        }

        System.out.println(answer);
    }

    static void grouping(int x, int y, int cnt) {
        group[x][y] = cnt;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                if (arr[nx][ny] == 1 && group[nx][ny] == 0) {
                    grouping(nx, ny, cnt);
                }
            }
        }
    }

    static int bfs(int cnt) {
        distance = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (group[i][j] == cnt) {
                    q.offer(new Pair(i, j));
                    distance[i][j] = 0;
                } else if (group[i][j] == 0) {
                    distance[i][j] = -1;
                } else {
                    distance[i][j] = -2;
                }
            }
        }

        int min = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            Pair p = q.poll();
            int tx = p.x;
            int ty = p.y;

            for (int i = 0; i < 4; i++) {
                int nx = tx + dx[i];
                int ny = ty + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    if (distance[nx][ny] == -2) {
                        min = Math.min(min, distance[tx][ty]);
                    } else if (distance[nx][ny] == -1) {
                        q.offer(new Pair(nx, ny));
                        distance[nx][ny] = distance[tx][ty] + 1;
                    }
                }
            }
        }

        return min;
    }

    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
