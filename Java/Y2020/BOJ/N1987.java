package Java.Y2020.BOJ;

import java.io.*;
import java.util.*;

public class N1987 {
    static int r, c;
    static int[][] arr;
    static boolean[] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int count = 1;
    static int answer = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = new int[r][c];
        visited = new boolean[26];

        for (int i = 0; i < r; i++) {
            String s = bf.readLine();

            for (int j = 0; j < c; j++) {
                arr[i][j] = (int)s.charAt(j) - 65;
            }
        }

        dfs(0, 0, arr[0][0]);

        System.out.println(answer);
    }

    static void dfs(int x, int y, int alpha) {
        visited[alpha] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < r && ny >= 0 && ny < c) {
                if (!visited[arr[nx][ny]]) {
                    answer = Math.max(answer, ++count);
                    dfs(nx, ny, arr[nx][ny]);
                }
            }
        }

        count--;
        visited[alpha] = false;
    }
}
