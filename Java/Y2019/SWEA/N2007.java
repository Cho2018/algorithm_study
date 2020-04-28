package Java.Y2019.SWEA;

import java.util.*;

public class N2007 {
    static int t;
    static int ans;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        t = in.nextInt();

        for (int T = 1; T <= t; T++) {
            ans = 0;
            String string = in.next();
            String pattern, patternNext;

            for (int i = 1; i < 10; i++) {
                pattern = string.substring(0, i);
                patternNext = string.substring(i, i + i);

                if (pattern.equals(patternNext)) {
                   ans = i;
                   break;
                }
            }

            System.out.println("#" + T + " " + ans);
        }
    }
}
