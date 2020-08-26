package Java.Y2020.BOJ;

import java.io.*;
import java.util.*;

public class N2206_2008 {
    static int n, m;
    static int[][] arr;
    static int[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int answer;

    static class Pair {
        int x, y;
        int move; // 이동 횟수
        int broken; // 벽 깬 횟수

        public Pair(int x, int y, int move, int broken) {
            this.x = x;
            this.y = y;
            this.move = move;
            this.broken = broken;
        }
    }

    static void ft_bfs(int x, int y) {
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(x, y, 1, 0));
        visited[x][y] = 0;

        while (!queue.isEmpty()) {
            Pair p = queue.poll();

            if (p.x == n - 1 && p.y == m - 1) {
                answer = p.move;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (visited[nx][ny] <= p.broken) continue;

                    if (arr[nx][ny] == 0) { // 0 : 이동할 수 있는 곳
                        queue.offer(new Pair(nx, ny, p.move + 1, p.broken));
                        visited[nx][ny] = p.broken;
                    } else { // 1 : 이동할 수 없는 곳
                        if (p.broken == 0) {
                            queue.offer(new Pair(nx, ny, p.move + 1, p.broken + 1));
                            visited[nx][ny] = p.broken + 1;
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        visited = new int[n][m];

        for (int i = 0; i < n; i++) {
            String string = bf.readLine();

            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(String.valueOf(string.charAt(j)));
                visited[i][j] = Integer.MAX_VALUE;
            }
        }

        answer = Integer.MAX_VALUE;

        ft_bfs(0, 0);

        if (answer == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }
}
