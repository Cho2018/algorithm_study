package Java.Y2020.BOJ;

import java.io.*;
import java.util.*;

public class N2750 {
    public static void main(String[] args) throws IOException {
        /*BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        int arr[] = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
        }

        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }*/

        // 카운팅 정렬
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

		// -1000 ~ 1000
        boolean[] arr = new boolean[2001];

        for (int i = 0; i < n; i++) {
            arr[Integer.parseInt(bf.readLine()) + 1000] = true;
        }

        for (int i = 0; i < 2001; i++) {
            if (arr[i]) {
                System.out.println(i - 1000);
            }
        }
    }
}
