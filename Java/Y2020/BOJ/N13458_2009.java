package Java.Y2020.BOJ;

import java.io.*;
import java.util.*;

public class N13458_2009 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine()); // 시험장의 개수
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken()); // 각 시험장에 있는 응시자의 수
        }

        st = new StringTokenizer(bf.readLine());
        int b = Integer.parseInt(st.nextToken()); // 총감독관이 감시할 수 있는 응시자 수
        int c = Integer.parseInt(st.nextToken()); // 부감독관이 감시할 수 있는 응시자 수

        long answer = 0;
        for (int i = 0; i < n; i++) {
            arr[i] -= b;
            answer++;

            if (arr[i] < 0) continue;

            if (arr[i] % c == 0) {
                answer += arr[i] / c;
            } else {
                answer += ((arr[i] / c) + 1);
            }
        }

        System.out.println(answer);
    }
}
