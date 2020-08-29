package Java.Y2020.BOJ;

import java.io.*;
import java.util.*;

public class N11727_2008 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        int[] dp = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            if (i == 0) dp[i] = 0;
            else if (i == 1) dp[i] = 1;
            else if (i == 2) dp[i] = 3;
            else {
                dp[i] = dp[i - 1] + (2 * dp[i - 2]);
                dp[i] %= 10007;
            }
        }

        System.out.println(dp[n]);
    }
}
