package Java.Y2020.BOJ;

import java.io.*;
import java.util.*;

public class N1016_2008 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());

        // 제곱 ㄴㄴ 수인지 확인 (제곱 ㄴㄴ 수 : false)
        int arr_size = (int)(max - min + 1);
        boolean[] arr = new boolean[arr_size];

        for (long i = 2; i * i <= max; i++) {
            long power = i * i;
            long start = min % power == 0? min / power : (min / power) + 1;

            for (long j = start; j * power <= max; j++) {
                arr[(int)((j * power) - min)] = true;
            }
        }

        int count = 0;
        for (int i = 0; i < arr_size; i++) {
            if (!arr[i])
                count++;
        }

        System.out.println(count);
    }
}
