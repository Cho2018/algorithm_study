package Java.Y2019.SWEA;

import java.util.*;

public class N1213 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        for (int T = 1; T <= 10; T++) {
            int t = in.nextInt();
            String find = in.next();
            String string = in.next();

            int count = 0;
            int from = -1;
            while ((from = string.indexOf(find, from + 1)) >= 0) {
                count++;
            }

            System.out.println("#" + t + " " + count);
        }
    }
}
