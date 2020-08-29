package Java.Y2020.BOJ;

import java.io.*;
import java.util.*;

public class N1912_2008 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        int[] arr = new int[n];
        int[] dp = new int[n];

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = arr[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max((dp[i - 1] + arr[i]), arr[i]);
        }

        Arrays.sort(dp);

        System.out.println(dp[n - 1]);
    }
}
