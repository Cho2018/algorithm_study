package Java.Y2020.BOJ;

import java.io.*;

public class N1003_2008 {
    // 결과적으로 모든 입력값의 0이 출력되는 횟수를 출력하는 것
    static int ft_func(int n) {
        int a = 1;
        int b = 0;
        int c = 1;

        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return 0;
        } else {
            for (int i = 1; i <= n; i++) {
                a = b;
                b = c;
                c = a + b;
            }

            return a;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bf.readLine());

        String answer;
        while (t-- != 0) {
            int n = Integer.parseInt(bf.readLine());
            answer = ft_func(n) + " " + ft_func(n + 1);
            System.out.println(answer);
        }
    }
}
