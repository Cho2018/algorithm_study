package Java.Y2019.SWEA;

import java.util.*;

public class N1859 {
    static int t;
    static int n;
    static int[] arr = new int[1000001];
    static long max_margin;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        t = in.nextInt();

        for (int a = 1; a <= t; a++) {
            n = in.nextInt();

            max_margin = 0;
            int max_price;

            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }

            max_price = arr[n - 1];

            for (int i = n - 2; i >= 0; i--) {
                if (max_price > arr[i]) {
                    max_margin += max_price - arr[i];
                } else {
                    max_price = arr[i];
                }
            }

            System.out.println("#" + a + " " + max_margin);
        }
    }
}
