package Java.Y2020.BOJ;

import java.io.*;
import java.util.*;

public class N1932_2008 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        int[][] dp = new int[n][n];
        dp[0][0] = Integer.parseInt(bf.readLine());
        int max = 0;

        for (int i = 1; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());

            for (int j = 0; j <= i; j++) {
                dp[i][j] = Integer.parseInt(st.nextToken());

                if (j == 0)
                    dp[i][j] += dp[i - 1][j];
                else if (j == i)
                    dp[i][j] += dp[i - 1][j - 1];
                else
                    dp[i][j] += Math.max(dp[i - 1][j - 1], dp[i - 1][j]);

                max = Math.max(max, dp[i][j]);
            }
        }

        System.out.println(max);
    }
}
