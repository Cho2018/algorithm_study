package Java.Y2019.SWEA;

import java.util.*;

public class N2001 {
    static int t;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        t = in.nextInt();

        for (int T = 1; T <= t; T++) {
            int n = in.nextInt();
            int m = in.nextInt();

            int[][] arr = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = in.nextInt();
                }
                in.nextLine();
            }

            //5 - 4/3/2/1   6 - 5/4/3/2
            int num = 0;
            for (int i = 0; i <= n - m ; i++) {
                for (int j = 0; j <= n - m; j++) {
                    int temp = 0;
                    for (int k = i; k < i + m; k++) {
                        for (int l = j; l < j + m; l++) {
                            temp += arr[k][l];
                        }
                    }

                    if (num < temp) {
                        num = temp;
                    }
                }
            }

            System.out.println("#" + T + " " + num);
        }
    }
}
