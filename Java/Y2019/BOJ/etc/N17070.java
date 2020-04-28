package Java.Y2019.BOJ.etc;

import java.util.*;

public class N17070 {
    static int[][] pipeG;
    static int n;
    static int count;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();

        pipeG = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                pipeG[i][j] = in.nextInt();
            }
            in.nextLine();
        }

        count = 0;

        doing(1, 2, 0);

        System.out.println(count);
    }

    //파이프 앞의 좌표, 방향
    static void doing(int r, int c, int d) {
        if (r == n && c == n) {
            count++;
            return;
        }

        //현재 방향이 아래쪽이 아니고, 파이프 앞 좌표의 오른쪽 칸이 비어있다면
        if (d != 2 && isRange(r, c + 1) && pipeG[r][c + 1] == 0) {
            doing(r, c + 1, 0);
        }

        //현재 방향이 오른쪽이 아니고, 파이프 앞 좌표의 아래 칸이 비어있다면
        if (d != 0 && isRange(r + 1, c) && pipeG[r + 1][c] == 0) {
            doing(r + 1, c, 2);
        }

        //파이프 앞 좌표의 주위 3 방향 모든 칸이 비어있다면
        if (isRange(r + 1, c + 1) && pipeG[r + 1][c] == 0
                && pipeG[r + 1][c + 1] == 0 && pipeG[r][c + 1] == 0) {
            doing(r + 1, c + 1, 1);
        }
    }

    static boolean isRange(int r, int c) {
        if (r <= 0 || r > n || c <= 0 || c > n) {
            return false;
        }
        return true;
    }
}
