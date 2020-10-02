package Java.Y2020.BOJ;

import java.io.*;
import java.util.*;

public class N14890_2010 {
    static int n, l;
    static int dir;
    static int[][] arr = new int[100][100];
    static int[][] built;
    static int[] dx = {0, 1};
    static int[] dy = {1, 0};
    static int answer = 0;

    static boolean ft_range(int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= n) {
            return false;
        }

        return true;
    }

    static void ft_dfs(int x, int y, int pre_value) {
        if (x == n || y == n) {
            answer++;
            return;
        }

        int nx = x + dx[dir];
        int ny = y + dy[dir];

        if (arr[x][y] == pre_value) {
            ft_dfs(nx, ny, arr[x][y]);
        } else if (arr[x][y] == pre_value + 1) {
            int pivot_value = arr[x][y];

            for (int i = 0; i < l; i++) {
                x -= dx[dir];
                y -= dy[dir];

                if (!ft_range(x, y) || built[x][y] == 1 || arr[x][y] + 1 != pivot_value) {
                    return;
                }

                built[x][y] = 1; // 경사로 세우는
            }

            ft_dfs(nx, ny, pre_value + 1);
        } else if (arr[x][y] == pre_value - 1) {
            int pivot_value = pre_value;

            for (int i = 0; i < l; i++) {
                if (!ft_range(x, y) || built[x][y] == 1 || arr[x][y] + 1 != pivot_value) {
                    return;
                }

                built[x][y] = 1; // 경사로 세우는

                x += dx[dir];
                y += dy[dir];
            }

            ft_dfs(x, y, pre_value - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());

            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // row
        dir = 0;
        for (int i = 0; i < n; i++) {
            built = new int[100][100];
            ft_dfs(i, 0, arr[i][0]);
        }

        // col
        dir = 1;
        for (int i = 0; i < n; i++) {
            built = new int[100][100];
            ft_dfs(0, i, arr[0][i]);
        }

        System.out.println(answer);
    }
}
