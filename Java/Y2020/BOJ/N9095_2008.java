package Java.Y2020.BOJ;

import java.io.*;
import java.util.*;

public class N9095_2008 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            int n = Integer.parseInt(bf.readLine());
            int[] arr = new int[n + 1];

            for (int i = 0; i <= n; i++) {
                if (i == 0) {
                    arr[i] = 0;
                } else if (i == 1) {
                    arr[i] = 1;
                } else if (i == 2) {
                    arr[i] = 2;
                } else if (i == 3) {
                    arr[i] = 4;
                } else {
                    arr[i] = arr[i - 1] + arr[i - 2] + arr[i - 3];
                }
            }

            sb.append(arr[n]).append("\n");
        }

        System.out.println(sb);
    }
}
