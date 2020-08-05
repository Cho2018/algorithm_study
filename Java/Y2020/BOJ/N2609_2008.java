package Java.Y2020.BOJ;

import java.io.*;
import java.util.*;

public class N2609_2008 {
    static int ft_gcd(int x, int y) {
        if (y == 0) {
            return x;
        }

        return ft_gcd(y, x % y);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int gcd = ft_gcd(a, b);
        int lcm = (a * b / gcd);

        StringBuilder sb = new StringBuilder();
        sb.append(gcd).append("\n").append(lcm).append("\n");
        System.out.println(sb);
    }
}
