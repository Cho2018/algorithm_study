package Java.Y2020.BOJ;

import java.io.*;
import java.util.*;

public class N1325 {
    static int n, m;
    static ArrayList<ArrayList<Integer>> arr;
    static boolean[] visited;
    static int[] answer = new int[10001];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new ArrayList<>(10001);

        for (int i = 0; i < 10001; i++) {
            arr.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr.get(x).add(y);
        }

        for (int i = 1; i <= n; i++) {
            visited = new boolean[10001];
            dfs(i);
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            if (max < answer[i]) {
                max = answer[i];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (max == answer[i]) {
                sb.append(i + " ");
            }
        }

        System.out.println(sb.toString());
    }

    static void dfs(int start) {
        visited[start] = true;

        for (int now : arr.get(start)) {
            if (visited[now] == false) {
                answer[now]++;
                dfs(now);
            }
        }
    }
}
