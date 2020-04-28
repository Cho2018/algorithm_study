package Java.Y2019.BOJ.DP;

import java.util.*;

public class N9461 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();

        long[] P = new long[101];
        P[1] = 1; P[2] = 1; P[3] = 1; P[4] = 2; P[5] = 2;
        for (int i = 6; i <= 100; i++) {
            P[i] = P[i - 1] + P[i - 5];
        }

        while (T-- != 0) {
            int N = in.nextInt();

            System.out.println(P[N]);
        }
    }
}
