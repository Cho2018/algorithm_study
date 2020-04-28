package Java.Y2019.BOJ.DP;

import java.util.*;

//시간 초과 때문에 재귀 함수 사용하지 않고 해결
public class N2748 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();

        long result = fib(n);

        System.out.println(result);
    }

    static long fib(long n) {
        long x = 0;
        long y = 1;
        long z = 1;

        if (n <= 1) {
            return n;
        } else {
            for (int i = 2; i <= n; i++) {
                y = x;
                x = z;
                z = x + y;
            }

            return z;
        }
    }
}
