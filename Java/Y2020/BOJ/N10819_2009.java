package Java.Y2020.BOJ;

import java.io.*;
import java.util.*;

public class N10819_2009 {
    static int answer = 0;

    static void ft_swap(int[] arr, int depth, int n) { // 그 배열안의 모든 원소들을 자리 이동하는
        int temp = arr[depth];
        arr[depth] = arr[n];
        arr[n] = temp;
    }

    static void ft_sum(int[] arr, int k) {
        int sum = 0;

        for (int i = 2; i <= k; i++) {
            sum += Math.abs(arr[i - 2] - arr[i - 1]);
        }

        if (answer < sum) {
            answer = sum;
        }
    }

    static void ft_perm(int[] arr, int depth, int n) { // 순열 만드는
        if (depth == n) {
            ft_sum(arr, n);
            return;
        }

        for (int i = depth; i < n; i++) {
            ft_swap(arr, i, depth);
            ft_perm(arr, depth + 1, n);
            ft_swap(arr, i, depth);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        ft_perm(arr, 0, n);

        System.out.println(answer);
    }
}
