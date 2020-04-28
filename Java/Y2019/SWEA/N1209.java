package Java.Y2019.SWEA;

import java.util.*;

public class N1209 {
    static int[][] arr = new int[100][100];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        for (int i = 1; i <= 10; i++) {
            int no = in.nextInt();

            for (int j = 0; j < 100; j++) {
                for (int k = 0; k < 100; k++) {
                    arr[j][k] = in.nextInt();
                }
                in.nextLine();
            }

            //row
            int rMax = 0;
            int rSum;
            for (int j = 0; j < 100; j++) {
                rSum = 0;
                for (int k = 0; k < 100; k++) {
                    rSum += arr[j][k];
                }

                if (rMax < rSum) {
                    rMax = rSum;
                }
            }

            //col
            int cMax = 0;
            int cSum;
            for (int k = 0; k < 100; k++) {
                cSum = 0;
                for (int j = 0; j < 100; j++) {
                    cSum += arr[j][k];
                }

                if (cMax < cSum) {
                    cMax = cSum;
                }
            }

            //d
            int dSum = 0;
            for (int j = 0; j < 100; j++) {
                dSum += arr[j][j];
            }

            //d2
            int d2Sum = 0;
            for (int j = 99; j >= 0; j--) {
                d2Sum += arr[j][j];
            }

            int finalMax = Math.max(rMax, Math.max(cMax, Math.max(dSum, d2Sum)));

            System.out.println("#" + i + " " + finalMax);
        }
    }
}
