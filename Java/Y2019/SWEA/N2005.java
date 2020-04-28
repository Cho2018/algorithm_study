package Java.Y2019.SWEA;

import java.util.*;

public class N2005 {
    static int t;
    static int[][] tri = new int[11][11];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        t = in.nextInt();

        for (int i = 1; i <= t; i++) {
            int n = in.nextInt();

            for (int j = 0; j < 11; j++) {
                for (int k = 0; k < 11; k++) {
                    tri[j][k] = 0;
                }
            }

            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    if (k == 1 || k == j) {
                        tri[j][k] = 1;
                    } else {
                        tri[j][k] = tri[j - 1][k - 1] + tri[j - 1][k];
                    }
                }
            }

            System.out.println("#" + i);
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    if (tri[j][k] != 0) {
                        System.out.print(tri[j][k] + " ");
                    }
                }
                System.out.println();
            }
        }
    }
}
