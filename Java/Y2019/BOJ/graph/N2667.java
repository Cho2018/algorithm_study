package Java.Y2019.BOJ.graph;

import java.util.*;

public class N2667 {
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n, count;
    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();

        graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            String string = in.next();
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(string.charAt(j) + "");
            }
        }

        visited = new boolean[n][n];
        for (int i = 0; i < n; i++ ) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] == 1 && visited[i][j] == false) {
                    count = 1;
                    dfs(i, j);
                    list.add(count);
                }
            }
        }

        Collections.sort(list);

        System.out.println(list.size());

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    static int dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                if (graph[nx][ny] == 1 && visited[nx][ny] == false) {
                    dfs(nx, ny);
                    count++;
                }
            }
        }

        return count;
    }
}
