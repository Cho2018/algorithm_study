package Java.Y2020.BOJ;

import java.io.*;
import java.util.*;

public class N1389 {
    static int n, m;
    static int[][] arr;
    static int[][] result;
    static Queue<Integer> q = new LinkedList<>();
    static int minSum = Integer.MAX_VALUE;
    static int minIndex;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n + 1][n + 1];
        result = new int[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[x][y] = arr[y][x] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                result[i][j] = -1;
            }
        }

        for (int i = n; i >= 1; i--) {
            bfs(i);
        }

        System.out.println(minIndex);
    }

    static void bfs(int index) {
        result[index][index] = 0;
        q.offer(index);

        while (!q.isEmpty()) {
            int temp = q.poll();

            for (int i = 1; i <= n; i++) {
                if (arr[temp][i] == 0 || result[index][i] != -1) continue;

                result[index][i] = result[index][temp] + 1;
                q.offer(i);
            }
        }

        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += result[index][i];
        }

        if (minSum >= sum) {
            minSum = sum;
            minIndex = index;
        }
    }
}
