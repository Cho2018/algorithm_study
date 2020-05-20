package Java.Y2020.BOJ;

import java.io.*;
import java.util.*;

public class N2206 {
    static int n, m;
    static int[][] arr;
    static int[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        visited = new int[n][m];

        for (int i = 0; i < n; i++) {
            String s = bf.readLine();

            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
                visited[i][j] = Integer.MAX_VALUE;
            }
        }

        answer = Integer.MAX_VALUE;

        bfs(0, 0);

        if (answer == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }

    static void bfs(int x, int y) {
        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(x, y, 1, 0));
        visited[x][y] = 0;

        while (!q.isEmpty()) {
            Pair p = q.poll();

            if (p.x == n - 1 && p.y == m - 1) {
                answer = p.move;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (visited[nx][ny] <= p.drill) continue;

                    if (arr[nx][ny] == 0) {
                        q.offer(new Pair(nx, ny, p.move + 1, p.drill));
                        visited[nx][ny] = p.drill;
                    } else {
                        if (p.drill == 0) {
                            q.offer(new Pair(nx, ny, p.move + 1, p.drill + 1));
                            visited[nx][ny] = p.drill + 1;
                        }
                    }
                }
            }
        }
    }

    static class Pair {
        int x, y, move, drill; // 이동 횟수, 벽 깬 횟수

        public Pair(int x, int y, int move, int drill) {
            this.x = x;
            this.y = y;
            this.move = move;
            this.drill = drill;
        }
    }
}
