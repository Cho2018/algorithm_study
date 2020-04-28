package Java.Y2019.BOJ.graph;

import java.util.*;

//0: 빈칸
//1: 벽
//2: 바이러스
//벽을 새로 꼭 3개 건설하는
public class N14502 {
    static int[][] graph;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N, M;
    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        M = in.nextInt();

        graph = new int[N][M];
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                graph[i][j] = map[i][j] = in.nextInt();
            }
            in.nextLine();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (graph[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(1);
                    map[i][j] = 0;
                }
            }
        }

        System.out.println(answer);
    }

    //3개의 벽 세우는
    static void dfs(int cnt) {
        if (cnt == 3) {
            bfs();
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(cnt + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    //바이러스가 주위로 퍼져 나가는
    static void bfs() {
        int[][] virus = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                virus[i][j] = map[i][j];
            }
        }

        Queue<Integer> qx = new LinkedList<>();
        Queue<Integer> qy = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (virus[i][j] == 2) {
                    qx.offer(i);
                    qy.offer(j);
                }
            }
        }

        while (!qx.isEmpty() && !qy.isEmpty()) {
            int x = qx.poll();
            int y = qy.poll();

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (virus[nx][ny] == 0) {
                        virus[nx][ny] = 2;
                        qx.offer(nx);
                        qy.offer(ny);
                    }
                }
            }
        }

        calAnswer(virus);
    }

    //안전지역 숫자 세는
    static void calAnswer(int[][] virus) {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (virus[i][j] == 0) {
                    cnt++;
                }
            }
        }

        answer= Math.max(cnt, answer);
    }
}
