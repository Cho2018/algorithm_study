package Java.Y2020.BOJ;

import java.io.*;
import java.util.*;

public class N1806 {
    static int n, s;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        arr = new int[n];

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int min = Integer.MAX_VALUE;
        int sum;
        int count;
        for (int i = 0; i < n; i++) {
            sum = 0;
            count = 0;

            for (int j = i; j < n; j++) {
                sum += arr[j];
                count++;

                if (sum >= s) {
                    min = Math.min(min, count);
                    break;
                }
            }
        }

        if (min == Integer.MAX_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(min);
        }
    }
}
