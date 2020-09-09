package Java.Y2020.BOJ;

import java.io.*;
import java.util.*;

public class N14500_2009 {
    static int n, m;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    // ㅜ ㅏ ㅗ ㅓ
    static int[][][] shape = {{{0, 0}, {0, 1}, {0, 2}, {1, 1}},
            {{0, 0}, {1, 0}, {2, 0}, {1, 1}},
            {{0, 0}, {0, 1}, {0, 2}, {-1, 1}},
            {{0, 0}, {1, 0}, {2, 0}, {1, -1}}};

    static int answer = 0;

    static void ft_solve_dfs(int x, int y, int count, int sum) {
        if (count == 4) { // 테트로미노 완성
            answer = Math.max(answer, sum);
            return;
        }

        if (count > 4) return;

        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
            if (visited[nx][ny]) continue;

            ft_solve_dfs(nx, ny, count + 1, sum + arr[nx][ny]);
        }

        // **point**
        visited[x][y] = false;
    }

    // **point**
    // dfs 불가 모양은 하나하나 구하기
    static void ft_shape(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int sum = 0;

            for (int j = 0; j < 4; j++) {
                int nx = x + shape[i][j][0];
                int ny = y + shape[i][j][1];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) break;

                sum += arr[nx][ny];
            }

            answer = Math.max(answer, sum);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());

            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ft_solve_dfs(i, j, 1, arr[i][j]);
                ft_shape(i, j);
            }
        }

        System.out.println(answer);
    }
}
