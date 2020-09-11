package Java.Y2020.BOJ;

import java.io.*;
import java.util.*;

public class N1476_2009 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        int e = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int fixed_e = 1, fixed_s = 1, fixed_m = 1;
        for (int i = 1; ; i++) {
            if (fixed_e == e && fixed_s == s && fixed_m == m) {
                System.out.println(i);
                break;
            }

            fixed_e++;
            fixed_s++;
            fixed_m++;

            if (fixed_e == 16) {
                fixed_e = 1;
            }

            if (fixed_s == 29) {
                fixed_s = 1;
            }

            if (fixed_m == 20) {
                fixed_m = 1;
            }
        }
    }
}
