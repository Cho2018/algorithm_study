package Java.Y2019.SWEA;

import java.util.*;

public class N1926 {
    static int n;
    static int count;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();

        for (int i = 1; i <= n; i++) {
            String str = String.valueOf(i);

            count = 0;
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == '3' || str.charAt(j) == '6' || str.charAt(j) == '9') {
                    count++;
                }
            }

            if (count == 0) {
                System.out.print(str + " ");
            } else {
                if (count == 1) {
                    System.out.print("- ");
                } else if (count == 2) {
                    System.out.print("-- ");
                } else if (count == 3) {
                    System.out.print("--- ");
                } else if (count == 4) {
                    System.out.print("---- ");
                }
            }
        }
    }
}
