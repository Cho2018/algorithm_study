package Java.Y2019.SWEA;

import java.util.*;

public class N8016 {
    static int t;
    static long n;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        t = in.nextInt();

        //1 1
        //3 7
        //9 17
        //19 31
        //33 49
        for (int T = 1; T <= t; T++) {
            n = in.nextLong();
            long a, b;

            a = (n - 1) * (n - 1) * 2 + 1;
            b = n * n * 2 - 1;

            System.out.println("#" + T + " " + a + " " +b);
        }
    }
}
