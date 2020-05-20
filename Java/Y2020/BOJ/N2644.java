package Java.Y2020.BOJ;

import java.util.*;

public class N2644 {
    static int n, m;
    static int start, end;
    static int[][] arr = new int[101][101];
    static int[] dp = new int[101];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        n = in.nextInt();

        start = in.nextInt();
        end = in.nextInt();

        m = in.nextInt();

        for (int i = 0; i < m; i++) {
            int x = in.nextInt();
            int y = in.nextInt();

            arr[x][y] = arr[y][x] = 1;
        }

        Queue<Integer> q = new LinkedList<>();

        q.offer(start);
        while (!q.isEmpty()) {
            int now = q.poll();

            for (int i = 1; i <= n; i++) {
                if (arr[now][i] == 0 || dp[i] != 0) continue;

                q.offer(i);
                dp[i] = dp[now] + 1;
            }
        }

        System.out.println(dp[end] == 0 ? -1 : dp[end]);
    }
}
