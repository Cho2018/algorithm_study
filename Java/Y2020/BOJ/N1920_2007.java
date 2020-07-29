package Java.Y2020.BOJ;

import java.io.*;
import java.util.*;

public class N1920_2007 {
    static int n, m;
    static int[] arr;

    static void ft_find(int x) {
        int answer = 0;
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == x) {
                answer = 1;
                break;
            } else if (arr[mid] > x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        System.out.println(answer);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(bf.readLine());
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        m = Integer.parseInt(bf.readLine());
        st = new StringTokenizer(bf.readLine());
        while (m-- > 0) {
            ft_find(Integer.parseInt(st.nextToken()));
        }
    }
}
