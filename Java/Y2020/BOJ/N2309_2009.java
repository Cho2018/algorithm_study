package Java.Y2020.BOJ;

import java.io.*;
import java.util.*;

public class N2309_2009 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[9];
        int sum = 0;
        boolean check = false;

        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
            sum += arr[i];
        }

        for (int i = 0; i < 9; i++) {
            if (check) break;

            for (int j = 0; j < 9; j++) {
                if (i == j) continue;

                // 인원 7명을 맞추는 과정
                if (sum - arr[i] - arr[j] == 100) {
                    arr[i] = 0;
                    arr[j] = 0;
                    check = true;
                    break;
                }
            }
        }

        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i < 9; i++) {
            sb.append(arr[i]).append("\n");
        }

        System.out.println(sb);
    }
}
