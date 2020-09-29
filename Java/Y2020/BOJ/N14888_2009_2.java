package Java.Y2020.BOJ;

import java.io.*;
import java.util.*;

public class N14888_2009_2 {
    static int n;
    static int[] arr;
    static int[] op;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    static void ft_solve(int add, int sub, int mul, int div, int result, int index) {
        if (index == n) {
            max = Math.max(max, result);
            min = Math.min(min, result);
            return;
        }

        if (add > 0) {
            ft_solve(add - 1, sub, mul, div, result + arr[index], index + 1);
        }

        if (sub > 0) {
            ft_solve(add, sub - 1, mul, div, result - arr[index], index + 1);
        }

        if (mul > 0) {
            ft_solve(add, sub, mul - 1, div, result * arr[index], index + 1);
        }

        if (div > 0) {
            ft_solve(add, sub, mul, div - 1, result / arr[index], index + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(bf.readLine()); // 수의 개수
        arr = new int[n];
        op = new int[4];

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < 4; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }

        ft_solve(op[0], op[1], op[2], op[3], arr[0], 1);

        StringBuilder sb = new StringBuilder();
        sb.append(max).append("\n").append(min);
        System.out.println(sb.toString());
    }
}
