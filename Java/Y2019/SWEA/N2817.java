package Java.Y2019.SWEA;

import java.util.*;

public class N2817 {
    static int t, n, k;
    static int[] arr = new int[20];
    static int answer;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        t = in.nextInt();

        for (int i = 1; i <= t; i++) {
            n = in.nextInt();
            k = in.nextInt();

            for (int j = 0; j < n; j++) {
                arr[j] = in.nextInt();
            }

            doing(0, 0);
            System.out.println("#" + i + " " + answer);
            answer = 0;
        }
    }

    static void doing(int i, int sum) {
        if (sum > k || i == n) {
            if (sum == k)
                answer++;
            return;
        }

        doing(i + 1, sum + arr[i]);
        doing(i + 1, sum);
    }
}
