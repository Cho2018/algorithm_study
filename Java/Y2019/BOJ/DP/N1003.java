package Java.Y2019.BOJ.DP;

import java.util.*;

public class N1003 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        String result;

        while (T-- != 0) {
            int N = in.nextInt();

            result = func1(N) + " " + func1(N + 1);

            System.out.println(result);
        }
    }

    static int func1(int N) {
        //N이 0일 경우 초기값
        int a = 1; //func1(0)
        int b = 0; //func1(1)
        int c = 1; //func1(0) + func1(1)

        if (N == 0) {
            return 1;
        } else if (N == 1) {
            return 0;
        } else {
            for (int i = 1; i <= N; i++) {
                a = b;
                b = c;
                c = a +b;
            }

            return a;
        }
    }
}
