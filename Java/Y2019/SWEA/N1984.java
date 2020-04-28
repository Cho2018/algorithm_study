package Java.Y2019.SWEA;

import java.util.*;

public class N1984 {
    static int t;
    static int[] arr;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        t = in.nextInt();

        for (int x = 0; x < t; x++) {
            arr = new int[10];
            for (int i = 0; i < 10; i++) {
                arr[i] = in.nextInt();
            }

            Arrays.sort(arr);

            int sum = 0;
            for (int i = 1; i < 9; i++) {
                sum += arr[i];
            }

            double result = (double)sum / 8;
            int real = (int)Math.round(result);

            System.out.println("#" + (x + 1) + " " + real);
        }
    }
}
