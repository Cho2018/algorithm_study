package Java.Y2019.SWEA;

import java.util.*;

public class N1204 {
    static int t, qnum;
    static int[] arr = new int[101];
    static int max = 0, maxIdx = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        t = in.nextInt();

        while (t-- != 0) {
            qnum = in.nextInt();

            for (int i = 0; i < arr.length; i++) {
                arr[i] = 0;
            }

            for (int i = 0; i < 1000; i++) {
                int k = in.nextInt();
                for (int j = 0; j < arr.length; j++) {
                    if (k == j) {
                        arr[j]++;
                        break;
                    }
                }
            }

            max = 0;
            maxIdx = 0;
            for (int i = 0; i < arr.length; i++) {
                if (max <= arr[i]) {
                    max = arr[i];
                    maxIdx = i;
                }
            }

            System.out.println("#" + qnum + " " + maxIdx);
        }
    }
}
