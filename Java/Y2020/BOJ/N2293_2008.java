package Java.Y2020.BOJ;

import java.io.*;
import java.util.*;

public class N2293_2008 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[101];
        int[] dp = new int[10001];

        for (int i = 1 ; i <= n ; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
        }

        dp[0] = 1;
        for (int i = 1 ; i <= n ; i++) {
            for (int j = arr[i]; j <= k ; j++) {
                dp[j] += dp[j - arr[i]];
            }
        }

        System.out.println(dp[k]);
    }
}
