package Java.Y2019.SWEA;

import java.util.*;

public class N1217 {
    static int t, n, m;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        for (int i = 1; i <= 10; i++) {
            t = in.nextInt();
            n = in.nextInt();
            m = in.nextInt();

            int sum = 1;
            while (m-- != 0) {
                sum *= n;
            }

            System.out.println("#" + i + " " + sum);
        }
    }
}
