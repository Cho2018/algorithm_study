package Java.Y2019.SWEA;

import java.util.*;

public class N1206 {
    static int n;
    static int[] arr;
    static int sum;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        for (int i = 0; i < 10; i++) {
            n = in.nextInt();

            arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = in.nextInt();
            }

            sum = 0;
            for (int j = 2; j <= n - 2; j++) {
                if (arr[j] > arr[j - 1] && arr[j] > arr[j - 2]
                        && arr[j] > arr[j + 1] && arr[j] > arr[j + 2]) {
                    int a = arr[j];
                    int b = arr[j - 1];
                    int c = arr[j - 2];
                    int d = arr[j + 1];
                    int e = arr[j + 2];

                    int t1 = a - b;
                    int t2 = a - c;
                    int t3 = a - d;
                    int t4 = a - e;

                    int min = Math.min(t1, Math.min(t2, Math.min(t3, t4)));

                    sum += min;
                }
            }

            System.out.println("#" + (i + 1) + " " + sum);
        }
    }
}
