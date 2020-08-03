package Java.Y2020.BOJ;

import java.io.*;
import java.util.*;

public class N1182_2008 {
    static int n, s;
    static int[] arr;
    static int count = 0;

    static void ft_check(int idx, int sum) {
        if (idx == n) {
            if (sum == s) {
                count++;
            }
            return;
        }

        ft_check(idx + 1, sum + arr[idx]);
        ft_check(idx + 1, sum);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        arr = new int[n];

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        ft_check(0, 0);

        // 구하고자 하는 합이 0인 경우 => 공집합 제외시키기 위해 count - 1 해줌
        // 이유 : 크기가 양수인 부분수열 중에서 구하는 것임
        System.out.println((s == 0)? --count : count);
    }
}
