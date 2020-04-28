package Java.Y2019.SWEA;

import java.util.*;

public class N1989 {
    static int t;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        t = in.nextInt();

        for (int T = 1; T <= t; T++) {
            String str = in.next();
            String[] strings = str.split("");

            int notsame = 0;
            for (int i = 0; i < strings.length / 2; i++) {
                if (!strings[i].equals(strings[strings.length - 1 - i])) {
                    notsame++;
                    break;
                }
            }

            if (notsame != 0) {
                System.out.println("#" + T + " " + 0);
            } else {
                System.out.println("#" + T + " " + 1);
            }
        }
    }
}
