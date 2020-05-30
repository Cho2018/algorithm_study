package Java.Y2020.BOJ;

import java.io.*;
import java.util.*;

public class N2573 {
    static int n, m;
    static int[][] arr;
    static int[][] ice;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        ice = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());

            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve();
    }

    static void solve() {
        int year = 0;

        while (true) {
            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (arr[i][j] != 0 && visited[i][j] == false) {
                        count++;
                        dfs(i, j);
                    }
                }
            }

            if (count == 0) {
                System.out.println(0);
                break;
            } else if (count >= 2) {
                System.out.println(year);
                break;
            }

            year++;
            melt();
        }
    }

    // 빙산 덩어리 계산 + 녹는 양 구하기
    static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                if (arr[nx][ny] == 0) {
                    ice[x][y]++;
                }

                if (arr[nx][ny] != 0 && visited[nx][ny] == false) {
                    dfs(nx, ny);
                }
            }
        }
    }

    // 녹은 후 arr 구하기 + 초기화 작업
    static void melt() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] -= ice[i][j];

                if (arr[i][j] < 0) {
                    arr[i][j] = 0;
                }

                ice[i][j] = 0;
                visited[i][j] = false;
            }
        }
    }
}
