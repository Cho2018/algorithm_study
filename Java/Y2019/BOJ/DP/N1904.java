package Java.Y2019.BOJ.DP;

import java.util.*;

public class N1904 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        long[] tile = new long[N + 1];
        tile[1] = 1;
        tile[2] = 2;

        for (int i = 3; i <= N; i++) {
            tile[i] = (tile[i - 1] + tile[i - 2]) % 15746;
        }

        System.out.println(tile[N]);
    }
}
