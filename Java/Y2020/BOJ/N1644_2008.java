package Java.Y2020.BOJ;

import java.io.*;
import java.util.*;

public class N1644_2008 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        // 소수 구하기 (소수 : false)
        boolean[] arr_prime = new boolean[n + 1];
        arr_prime[0] = arr_prime[1] = true;

        for (int i = 2; i * i <= n; i++) {
            if (!arr_prime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    arr_prime[j] = true;
                }
            }
        }

        ArrayList<Integer> list_prime_num = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (!arr_prime[i]) {
                list_prime_num.add(i);
            }
        }

        int start = 0, end = 0;
        int sum = 0;
        int count = 0;
        while (true) {
            if (sum >= n) {
                sum -= list_prime_num.get(start++);
            } else if (end == list_prime_num.size()) {
                break;
            } else {
                sum += list_prime_num.get(end++);
            }

            if (sum == n) {
                count++;
            }
        }

        System.out.println(count);
    }
}
