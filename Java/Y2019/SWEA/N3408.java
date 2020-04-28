package Java.Y2019.SWEA;

import java.util.*;

//for문으로 경우의 수 하나하나 따지면 오류
public class N3408 {
    static int t;
    static long n;
    static long[] s;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        t = in.nextInt();

        for (int T = 1; T <= t; T++) {
            n = in.nextLong();
            s = new long[3];

            s[0] = n * (n + 1) / 2;
            s[2] = s[0] * 2;
            s[1] = s[2] - n;

            System.out.println("#" + T + " " + s[0] + " " + s[1] + " " + s[2]);
        }
    }
}
