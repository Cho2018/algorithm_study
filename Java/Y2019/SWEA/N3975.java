package Java.Y2019.SWEA;

import java.util.*;

public class N3975 {
    static int t;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        t = in.nextInt();

        for (int T = 1; T <= t; T++) {
            int ax = in.nextInt();
            int ay = in.nextInt();
            int bx = in.nextInt();
            int by = in.nextInt();

            double ares = (double)ax/ay;
            double bres = (double)bx/by;

            if (ares > bres) {
                System.out.println("#" + T + " " + "ALICE");
            } else if (ares == bres) {
                System.out.println("#" + T + " " + "DRAW");
            } else {
                System.out.println("#" + T + " " + "BOB");
            }
        }
    }
}
