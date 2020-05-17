package Java.Y2020.BOJ;

import java.io.*;
import java.util.*;

public class N14502 {
    static int n, m;
    static int[][] arr;
    static int[][] copy;
    static boolean[][] buildVisited;
    static boolean[][] dVisited;
    static int col;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int num;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        copy = new int[n][m];
        buildVisited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());

            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                copy[i][j] = arr[i][j];
            }
        }

        // 3개의 벽 세우기
        build();

        System.out.println(max);
    }

    static void build() {
        if (col == 3) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    copy[i][j] = arr[i][j];
                }
            }

            // 바이러스 퍼지기
            dVisited = new boolean[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (copy[i][j] == 2 && dVisited[i][j] == false) {
                        dfs(i, j);
                    }
                }
            }

            // 안전 영역 카운트
            num = bfs();

            max = Math.max(max, num);
        } else if (col < 3) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (arr[i][j] == 0 && buildVisited[i][j] == false) {
                        col++;
                        buildVisited[i][j] = true;
                        arr[i][j] = 1;
                        build();
                        col--;
                        buildVisited[i][j] = false;
                        arr[i][j] = 0;
                    }
                }
            }
        }
    }

    static void dfs(int x, int y) {
        dVisited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                if (copy[nx][ny] == 0 && dVisited[nx][ny] == false) {
                    copy[nx][ny] = 2;
                    dfs(nx, ny);
                }
            }
        }
    }

    static int bfs() {
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (copy[i][j] == 0) {
                    count++;
                }
            }
        }

        return count;
    }
}
