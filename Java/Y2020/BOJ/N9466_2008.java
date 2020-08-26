package Java.Y2020.BOJ;

import java.io.*;
import java.util.*;

public class N9466_2008 {
    static int n;
    static int[] arr;
    static boolean[] visited;
    static boolean[] done;
    static int count;

    static void ft_dfs(int index) {
        if (visited[index]) {
            done[index] = true;
            count++;
        } else {
            visited[index] = true;
        }

        if (!done[arr[index]]) {
            ft_dfs(arr[index]);
        }

        visited[index] = false;
        done[index] = true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bf.readLine());

        while (t-- > 0) {
            n = Integer.parseInt(bf.readLine());

            arr = new int[n + 1];
            visited = new boolean[n + 1];
            done = new boolean[n + 1];

            count = 0;

            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int i = 1; i <= n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= n; i++) {
                if (!done[i]) {
                    ft_dfs(i);
                }
            }

            System.out.println(n - count);
        }
    }
}
