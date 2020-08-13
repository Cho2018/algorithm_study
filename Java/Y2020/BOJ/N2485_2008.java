package Java.Y2020.BOJ;

import java.io.*;

public class N2485_2008 {
    static int ft_gcd(int x, int y) {
        if (y == 0) {
            return x;
        }

        return ft_gcd(y, x % y);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
        }

        // 가로수 간의 거리 구하기
        int[] distance = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            distance[i] = arr[i + 1] - arr[i];
        }

        // 가로수 간의 거리 최대공약수 구하기
        int gcd = 0;
        gcd = ft_gcd(distance[0], distance[1]);

        for (int i = 2; i < n - 1; i++) {
            gcd = ft_gcd(gcd, distance[i]);

            if (gcd == 1) break;
        }

        int answer = 0;
        for (int i = 0; i < n - 1; i++) {
            answer += ((distance[i] / gcd) - 1);
        }

        System.out.println(answer);
    }
}
