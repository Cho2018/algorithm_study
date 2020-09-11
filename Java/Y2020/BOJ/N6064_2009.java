package Java.Y2020.BOJ;

import java.io.*;
import java.util.*;

public class N6064_2009 {
    static int ft_gcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }

        return a;
    }

    static int ft_lcm(int a, int b) {
        return (a * b) / ft_gcd(a, b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(bf.readLine());

            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int count = x % (m + 1); // count
            int temp_y = x; // y 식에서 괄호 안을 의미

            for (int i = 0; i < n; i++) {
                int fixed_y = (temp_y % n == 0)? n : (temp_y % n); // y

                if (fixed_y == y) {
                    break;
                }

                temp_y = fixed_y + m;
                count += m;
            }

            sb.append(count > ft_lcm(m, n)? "-1" : count).append("\n");
        }

        System.out.println(sb);
    }
}
