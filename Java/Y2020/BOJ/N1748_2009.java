package Java.Y2020.BOJ;

import java.io.*;
import java.util.*;

public class N1748_2009 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String temp = bf.readLine();
        int n = Integer.parseInt(temp);
        int len = temp.length();

        // 1 ~ 9 : 9 --- 1 * 9
        // 10 ~ 99 : 90 --- 2 * 90
        // 100 ~ 999 : 900 --- 3 * 900

        // 120 -> 252
        // 1 * 9 + 2 * 90 = 9 + 180 = 189 / 120 - 100 = 20 / 20 + 1 = 21 / 3 * 21 = 63 / 189 + 63 = 252

        int answer = 0;
        int count = 9;
        for (int i = 1; i < len; i++) {
            answer += i * count;
            count *= 10;
        }

        answer += (len * (n - Math.pow(10, len - 1) + 1));

        System.out.println(answer);
    }
}
