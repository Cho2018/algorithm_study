package Java.Y2020.BOJ;

import java.io.*;
import java.util.*;

public class N14499_2009 {
    static int n, m, x, y, k;
    static int[][] arr;
    static int[] dice = {0, 0, 0, 0, 0, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    static void ft_roll_dice(int dir) {
        int[] temp_dice = new int[7];
        for (int i = 0; i < 7; i++) {
            temp_dice[i] = dice[i];
        }

        if (dir == 1) {
            dice[1] = temp_dice[6];
            dice[6] = temp_dice[3];
            dice[3] = temp_dice[5];
            dice[5] = temp_dice[1];
        } else if (dir == 2) {
            dice[1] = temp_dice[5];
            dice[6] = temp_dice[1];
            dice[3] = temp_dice[6];
            dice[5] = temp_dice[3];
        } else if (dir == 3) {
            dice[1] = temp_dice[2];
            dice[4] = temp_dice[1];
            dice[3] = temp_dice[4];
            dice[2] = temp_dice[3];
        } else if (dir == 4) {
            dice[1] = temp_dice[4];
            dice[2] = temp_dice[1];
            dice[3] = temp_dice[2];
            dice[4] = temp_dice[3];
        }
    }

    static void ft_change_dice(int x, int y, int dice_index) {
        if (arr[x][y] == 0) {
            arr[x][y] = dice[dice_index];
        } else {
            dice[dice_index] = arr[x][y];
            arr[x][y] = 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());

            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < k; i++) {
            int dir = Integer.parseInt(st.nextToken());

            // 동 : 1
            // 서 : 2
            // 북 : 3
            // 남 : 4

            x += dx[dir - 1];
            y += dy[dir - 1];

            if (x < 0 || x >= n || y < 0 || y >= m) {
                x -= dx[dir - 1];
                y -= dy[dir - 1];
                continue;
            }

            // 주사위 위 : 1
            // 주사위 앞 : 2
            // 주사위 아래 : 3
            // 주사위 뒤 : 4
            // 주사위 오 : 5
            // 주사위 왼 : 6

            if (dir == 1) {
                ft_change_dice(x, y, 5);
            } else if (dir == 2) {
                ft_change_dice(x, y, 6);
            } else if (dir == 3) {
                ft_change_dice(x, y, 4);
            } else if (dir == 4) {
                ft_change_dice(x, y, 2);
            }

            ft_roll_dice(dir);

            System.out.println(dice[1]);
        }
    }
}
