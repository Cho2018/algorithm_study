package Java.Y2020.BOJ;

import java.io.*;
import java.util.*;

public class N14889_2009 {
    static int n;
    static int[][] arr = new int[20][20];
    static int[] picked = new int[20];
    static int answer = Integer.MAX_VALUE;

    static void ft_dfs(int index, int count) {
        if (count == n / 2) {
            int sum1 = 0;
            int sum2 = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (picked[i] == picked[j] && picked[i] == 1) {
                        sum1 += arr[i][j];
                    }

                    if (picked[i] == picked[j] && picked[i] == 0) {
                        sum2 += arr[i][j];
                    }
                }
            }

            answer = Math.min(answer, Math.abs(sum1 - sum2));
        }

        for (int i = index; i < n; i++) {
            picked[i] = 1;
            ft_dfs(i + 1, count + 1);
            picked[i] = 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(bf.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());

            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        ft_dfs(0, 0);

        System.out.println(answer);
    }
}
