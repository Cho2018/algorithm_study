package Java.Y2019.SWEA;

import java.util.*;

//런타임 에러
public class N3750 {
    static int t;
    static int n;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        t = in.nextInt();

        for (int i = 1; i <= t; i++) {
            n = in.nextInt();

            doing(i, n);
        }
    }

    static void doing(int num, int n) {
        String str = String.valueOf(n);
        String[] strings = str.split("");

        int sum = 0;
        for (int i = 0; i < strings.length; i++) {
            sum += Integer.parseInt(strings[i]);
        }

        String ch = String.valueOf(sum);
        String[] checks = ch.split("");

        if (checks.length == 1) {
            System.out.println("#" + num + " " + sum);
            return;
        } else {
            doing(num, sum);
        }
    }
}
