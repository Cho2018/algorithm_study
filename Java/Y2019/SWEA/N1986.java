package Java.Y2019.SWEA;

import java.util.*;

public class N1986 {
    static int t;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        t = in.nextInt();

        for (int T = 1; T <= t; T++) {
            int n = in.nextInt();

            int sum = 0;
            for (int i = 1; i <= n; i++) {
                if (i % 2 == 0) {
                    sum = sum - i;
                } else {
                    sum = sum + i;
                }
            }

            System.out.println("#" + T + " " + sum);
        }
    }
}
