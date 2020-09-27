package Java.Y2020.BOJ;

import java.io.*;
import java.util.*;

public class N14501_2009 {
    static int n;
    static int[] t_arr; // 상담 소요 기간
    static int[] p_arr; // 상담 금액
    static int answer = 0;

    static void ft_dfs(int index, int cost) {
        if (index == n) {
            answer = Math.max(answer, cost);
            return;
        }

        if (index > n) {
            return;
        }

        ft_dfs(index + t_arr[index], cost + p_arr[index]); // 포함
        ft_dfs(index + 1, cost); // 미포합
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(bf.readLine());
        t_arr = new int[n];
        p_arr = new int[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            t_arr[i] = Integer.parseInt(st.nextToken());
            p_arr[i] = Integer.parseInt(st.nextToken());
        }

        ft_dfs(0, 0);

        System.out.println(answer);
    }
}
