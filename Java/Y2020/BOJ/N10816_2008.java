package Java.Y2020.BOJ;

import java.io.*;
import java.util.*;

public class N10816_2008 {
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    static void ft_find(int x) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (mid > x) {
                high = mid - 1;
            } else if (mid == x) {
                sb.append(arr[mid]).append(" ");
                break;
            } else {
                low = mid + 1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        arr = new int[20000001];

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            arr[Integer.parseInt(st.nextToken()) + 10000000]++;
        }

        int m = Integer.parseInt(bf.readLine());

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < m; i++) {
            ft_find(Integer.parseInt(st.nextToken()) + 10000000);
        }

        System.out.println(sb);
    }
}
