package Java.Y2020.BOJ;

import java.io.*;
import java.util.*;

public class N14889_2008 {
    static int n;
    static int[][] arr;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;

    static void ft_find(int count, int index) {
        if (count == (n / 2)) {
            int left_index = 0;
            int right_index = 0;

            int[] left_arr = new int[n / 2];
            int[] right_arr = new int[n / 2];

            int left_sum = 0;
            int right_sum = 0;

            for (int i = 0; i < n; i++) {
                if (visited[i]) left_arr[left_index++] = i;
                else right_arr[right_index++] = i;
            }

            for (int i = 0; i < (n / 2); i++) {
                for (int j = i + 1; j < (n / 2); j++) {
                    left_sum += arr[left_arr[i]][left_arr[j]];
                    left_sum += arr[left_arr[j]][left_arr[i]];
                    right_sum += arr[right_arr[i]][right_arr[j]];
                    right_sum += arr[right_arr[j]][right_arr[i]];
                }
            }

            min = Math.min(min, Math.abs(right_sum - left_sum));

            return;
        }

        for (int i = index; i < n; i++) {
            if (visited[i]) continue;

            visited[i] = true;
            ft_find(count + 1, i);
            visited[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(bf.readLine());
        arr = new int[n][n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());

            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        ft_find(0, 0);

        System.out.println(min);
    }
}
