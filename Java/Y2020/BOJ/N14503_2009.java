package Java.Y2020.BOJ;

import java.io.*;
import java.util.*;

public class N14503_2009 {
    static int n, m;
    static int r, c, d;
    static int dir;
    static int[][] arr = new int[50][50];
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int answer = 0;

    static void ft_cal() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 7) {
                    answer++;
                }
            }
        }
    }

    static void ft_solve(int x, int y, int check_four) {
        if (check_four == 4) {
            int temp_x = x - dx[dir];
            int temp_y = y - dy[dir];

            if (arr[temp_x][temp_y] == 1) {
                return;
            }

            ft_solve(temp_x, temp_y, 0);
        } else {
            // 0 : 빈 칸
            // 1 : 벽
            // 7 : 청소 완료

            // 북 : 0
            // 동 : 1
            // 남 : 2
            // 서 : 3

            if (arr[x][y] == 0) {
                arr[x][y] = 7;
            }

            dir = (d == 0) ? 3 : d - 1; // 현재 방향 기준 왼쪽방향부터 차례대로 탐색 진행
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if ((nx >= 0 && nx < n) && (ny >= 0 && ny < m)) {
                if (arr[nx][ny] == 0) {
                    d = dir;
                    ft_solve(nx, ny, 0);
                } else {
                    d = dir;
                    ft_solve(x, y, check_four + 1);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());
        r = Integer.parseInt(st.nextToken()); // 로봇 청소기 위치 : (r, c)
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken()); // 로봇 청소기가 바라보는 방향 : d

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());

            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        ft_solve(r, c, 0);

        ft_cal();

        System.out.println(answer);
    }
}
