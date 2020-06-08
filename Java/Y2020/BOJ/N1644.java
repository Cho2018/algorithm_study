package Java.Y2020.BOJ;

import java.io.*;
import java.util.*;

public class N1644 {
    static int n;
    static boolean[] prime;
    static ArrayList<Integer> primeNumbers = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(bf.readLine());

        // 소수 구하기
        // 소수는 false
        prime = new boolean[n + 1];
        prime[0] = prime[1] = true;

        for (int i = 2; i * i <= n; i++) {
            if (!prime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    prime[j] = true;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (!prime[i]) {
                primeNumbers.add(i);
            }
        }

        int start = 0, end = 0;
        int sum = 0;
        int count = 0;
        while (true) {
            if (sum >= n) {
                sum -= primeNumbers.get(start++);
            } else if (end == primeNumbers.size()) {
                break;
            } else {
                sum += primeNumbers.get(end++);
            }

            if (sum == n) {
                count++;
            }
        }

        System.out.println(count);
    }
}
