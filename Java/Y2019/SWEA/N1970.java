package Java.Y2019.SWEA;

import java.util.*;

public class N1970 {
    static int t;
    static int n;
    static int[] arr = new int[]{50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1};
    static int[] count;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        t = in.nextInt();

        for (int T = 1; T <= t; T++) {
            n = in.nextInt();
            count = new int[10];

            int i = 0;
            while (n != 0) {
                if (n < 0) {
                    count[i]--;
                    n += arr[i++];
                } else {
                    count[i]++;
                    n -= arr[i];
                }
            }

            System.out.println("#" + T);
            for (int j = 0; j < count.length; j++) {
                System.out.print(count[j] + " ");
            }
            System.out.println();
        }
    }
}
