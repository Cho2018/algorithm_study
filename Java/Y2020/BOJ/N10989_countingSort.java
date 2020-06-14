package Java.Y2020.BOJ;

import java.io.*;
import java.util.*;

public class N10989_countingSort {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        int[] arr = new int[10001];

        for (int i = 0; i < n; i++) {
            arr[Integer.parseInt(bf.readLine())] += 1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < arr.length; i++) {
            while (arr[i] > 0) {
                sb.append(i).append('\n');
                arr[i] -= 1;
            }
        }

        System.out.println(sb);
    }
}
