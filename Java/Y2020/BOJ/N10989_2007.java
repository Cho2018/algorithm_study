package Java.Y2020.BOJ;

import java.io.*;
import java.util.*;

public class N10989_2007 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        int[] arr = new int[10001];

        for (int i = 0; i < n; i++)
            arr[Integer.parseInt(bf.readLine())]++;

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < 10001; i++) {
            while (arr[i] > 0) {
                bw.write(String.valueOf(i) + "\n");
                arr[i]--;
            }
        }

        bw.close();
    }
}
