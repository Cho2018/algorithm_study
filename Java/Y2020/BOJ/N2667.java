package Java.Y2020.BOJ;

import java.io.*;
import java.util.*;

public class N2667 {
    static int n;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(bf.readLine());

        arr = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String s = bf.readLine();

            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1 && visited[i][j] == false) {
                    dfs(i, j);
                    list.add(count);
                    count = 0;
                }
            }
        }

        Collections.sort(list);

        System.out.println(list.size());
        for (int answer : list) {
            System.out.println(answer);
        }
    }

    static void dfs(int x, int y) {
        count++;
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                if (arr[nx][ny] == 1 && visited[nx][ny] == false) {
                    dfs(nx, ny);
                }
            }
        }
    }
}
