package Java.Y2020.BOJ;

import java.io.*;
import java.util.*;

public class N14502_2009 {
    static int n, m;
    static int[][] arr = new int[8][8];
    static ArrayList<Pair> list = new ArrayList<>();
    static ArrayList<Pair> virus_list = new ArrayList<>();
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int answer = 0;

    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int ft_bfs_cal() {
        int[][] after_arr = new int[8][8];
        Queue<Pair> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                after_arr[i][j] = arr[i][j];
            }
        }

        for (int i = 0; i < virus_list.size(); i++) {
            queue.offer(new Pair(virus_list.get(i).x, virus_list.get(i).y));
        }

        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            int x = p.x;
            int y = p.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }

                if (after_arr[nx][ny] == 2) {
                    continue;
                }

                if (arr[nx][ny] == 0 && after_arr[nx][ny] == 0) {
                    after_arr[nx][ny] = 2;
                    queue.offer(new Pair(nx, ny));
                } else if (arr[nx][ny] == 1 || arr[nx][ny] == 2) {
                    after_arr[nx][ny] = 1;
                    continue;
                }
            }
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (after_arr[i][j] == 0) {
                    cnt++;
                }
            }
        }

        return cnt;
    }

    static void ft_dfs_wall(int index, int wall_count) { // 벽 무조건 3개 세워야 함
        if (wall_count == 3) {
            int temp = ft_bfs_cal();
            answer = Math.max(answer, temp);
            return;
        }

        for (int i = index; i < list.size(); i++) {
            arr[list.get(i).x][list.get(i).y] = 1;
            ft_dfs_wall(i + 1, wall_count + 1);
            arr[list.get(i).x][list.get(i).y] = 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // 0 : 빈 칸
        // 1 : 벽
        // 2 : 바이러스

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());

            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                if (arr[i][j] == 0) {
                    list.add(new Pair(i, j));
                } else if (arr[i][j] == 2) {
                    virus_list.add(new Pair(i, j));
                }
            }
        }

        ft_dfs_wall(0, 0);

        System.out.println(answer);
    }
}
