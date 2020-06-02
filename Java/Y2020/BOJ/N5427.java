package Java.Y2020.BOJ;

import java.io.*;
import java.util.*;

public class N5427 {
    static int w, h;
    static int[][] arr;
    static Queue<Pair> q = new LinkedList<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bf.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            arr = new int[h + 2][w + 2];

            for (int i = 1; i < h + 1; i++) {
                String s = bf.readLine();

                for (int j = 1; j < w + 1; j++) {
                    if (s.charAt(j - 1) == '.') {
                        arr[i][j] = 0;
                    } else if (s.charAt(j - 1) == '#') {
                        arr[i][j] = -1;
                    } else if (s.charAt(j - 1) == '@') {
                        arr[i][j] = 3;
                    } else if (s.charAt(j - 1) == '*') {
                        arr[i][j] = 1;
                    }
                }
            }

            answer = Integer.MAX_VALUE;
            bfs();

            if (answer != Integer.MAX_VALUE) {
                System.out.println(answer);
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }
    }

    static void bfs() {
        for (int i = 1; i < h + 1; i++) {
            for (int j = 1; j < w + 1; j++) {
                if (arr[i][j] == 1) {
                    q.offer(new Pair(i, j, 1, 0));
                }
            }
        }

        for (int i = 1; i < h + 1; i++) {
            for (int j = 1; j < w + 1; j++) {
                if (arr[i][j] == 3) {
                    q.offer(new Pair(i, j, 3, 0));
                }
            }
        }

        while (!q.isEmpty()) {
            Pair p = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (p.x == 0 || p.x == h + 1 || p.y == 0 || p.y == w + 1) {
                    answer = Math.min(answer, p.time);
                }

                if (nx > 0 && nx < h + 1 && ny > 0 && ny < w + 1) {
                    if (p.c == 1) {
                        if (arr[nx][ny] == 0 || arr[nx][ny] == 3) {
                            arr[nx][ny] = 1;
                            q.offer(new Pair(nx, ny, p.c, p.time));
                        }
                    }
                }

                if (nx >= 0 && nx <= h + 1 && ny >= 0 && ny <= w + 1) {
                    if (p.c == 3) {
                        if (arr[nx][ny] == 0) {
                            arr[nx][ny] = 3;
                            q.offer(new Pair(nx, ny, p.c, p.time + 1));
                        }
                    }
                }
            }
        }
    }

    static class Pair {
        int x, y;
        int c;
        int time;

        public Pair(int x, int y, int c, int time) {
            this.x = x;
            this.y = y;
            this.c = c;
            this.time = time;
        }
    }
}
