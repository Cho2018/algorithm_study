package Java.Y2020.BOJ;

import java.io.*;
import java.util.*;

public class N6588_2008 {
    static final int MAX = 1000000;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        // 소수 구하기 (소수 : true)
        boolean[] arr_prime = new boolean[MAX + 1];
        for (int i = 2; i <= MAX; i++) {
            arr_prime[i] = true;
        }

        for (int i = 2; i * i <= MAX; i++) {
            if (!arr_prime[i]) continue;

            for (int j = i * i; j <= MAX; j += i) {
                arr_prime[j] = false;
            }
        }

        while (true) {
            int n = Integer.parseInt(bf.readLine());
            boolean possible = false;

            if (n == 0) break;

            for (int i = 2; i <= n / 2; i++) {
                if (arr_prime[i] && arr_prime[n - i]) {
                    System.out.println(n + " = " + i + " + " + (n - i));
                    possible = true;
                    break;
                }
            }

            if (!possible) System.out.println("Goldbach's conjecture is wrong.");
        }
    }
}
