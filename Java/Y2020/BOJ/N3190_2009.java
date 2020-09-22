package Java.Y2020.BOJ;

import java.io.*;
import java.util.*;

public class N3190_2009 {
    static int[] dx = {-1, 0, 1, 0}; // 북동남서 시계방향
    static int[] dy = {0, 1, 0, -1};

    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine()); // 보드 크기
        int k = Integer.parseInt(bf.readLine()); // 사과 개수

        int[][] arr = new int[n][n]; // 1 : 사과, 2 : 뱀의 흔적
        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr[r - 1][c - 1] = 1;
        }

        int l = Integer.parseInt(bf.readLine()); // 뱀의 방향 변환 횟수
        String[][] comm = new String[l][2];

        for (int i = 0; i < l; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            comm[i][0] = st.nextToken();
            comm[i][1] = st.nextToken();
        }

        int time = 0;
        int dir = 1; // 오른쪽부터 => 동쪽
        int index = 0;

        arr[0][0] = 2;
        Deque<Pair> snake = new LinkedList<>();
        snake.add(new Pair(0, 0));

        while (true) {
            if (index < l && Integer.parseInt(comm[index][0]) == time) {
                if (comm[index][1].equals("D")) {
                    dir = (dir == 3) ? 0 : dir + 1;
                    index++;
                } else {
                    dir = (dir == 0) ? 3 : dir - 1;
                    index++;
                }
            }

            int nx = snake.getFirst().x + dx[dir];
            int ny = snake.getFirst().y + dy[dir];

            if (nx < 0 || nx >= n || ny < 0 || ny >= n) { // 벽에 부딪힘
                break;
            }

            if (arr[nx][ny] == 2) { // 자기 몸에 부딪힘
                break;
            }

            if (arr[nx][ny] == 1) {
                arr[nx][ny] = 2;
                snake.addFirst(new Pair(nx, ny));
            } else if (arr[nx][ny] == 0) {
                arr[nx][ny] = 2;
                snake.addFirst(new Pair(nx, ny));

                Pair p = snake.removeLast();
                arr[p.x][p.y] = 0;
            }

            time++;
        }

        System.out.println(time + 1);
    }
}
