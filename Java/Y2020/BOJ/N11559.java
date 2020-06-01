package Java.Y2020.BOJ;

import java.io.*;
import java.util.*;

public class N11559 {
    static char[][] arr;
    static boolean[][] visited;
    static ArrayList<Pair> list;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        arr = new char[12][6];
        visited = new boolean[12][6];
        list = new ArrayList<>();

        for (int i = 0; i < 12; i++) {
            String s = bf.readLine();

            for (int j = 0; j < 6; j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        solve();

        System.out.println(answer);
    }

    static void solve() {
        while (true) {
            boolean flag = true;

            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    visited[i][j] = false;
                }
            }

            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if (arr[i][j] != '.' && visited[i][j] == false) {
                        bfs(i, j);
                    }

                    if (list.size() >= 4) {
                        flag = false;

                        for (Pair p : list) {
                            arr[p.x][p.y] = '.';
                        }
                    }

                    list.clear();
                }
            }

            ground();

            if (flag) {
                break;
            } else {
                answer += 1;
            }
        }
    }

    static void bfs(int x, int y) {
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(x, y));
        visited[x][y] = true;
        list.add(new Pair(x, y));

        char data = arr[x][y];
        while (!q.isEmpty()) {
            Pair p = q.poll();
            int tx = p.x;
            int ty = p.y;

            for (int i = 0; i < 4; i++) {
                int nx = tx + dx[i];
                int ny = ty + dy[i];

                if (nx >= 0 && nx < 12 && ny >= 0 && ny < 6) {
                    if (arr[nx][ny] == data && visited[nx][ny] == false) {
                        q.offer(new Pair(nx, ny));
                        visited[nx][ny] = true;
                        list.add(new Pair(nx, ny));
                    }
                }
            }
        }
    }

    static void ground() {
        for (int i = 0; i < 6; i++) {
            for (int j = 11; j > 0; j--) {
                if (arr[j][i] == '.') {
                    for (int k = j - 1; k >= 0; k--) {
                        if (arr[k][i] != '.') {
                            arr[j][i] = arr[k][i];
                            arr[k][i] = '.';
                            break;
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
