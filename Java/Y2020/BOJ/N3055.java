package Java.Y2020.BOJ;

import java.io.*;
import java.util.*;

public class N3055 {
    static int r, c;
    static int finalX, finalY;
    static char[][] arr;
    static int[][] count;
    static Queue<Pair> q = new LinkedList<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = new char[r][c];
        count = new int[r][c];

        for (int i = 0; i < r; i++) {
            String s = bf.readLine();

            for (int j = 0; j < c; j++) {
                arr[i][j] = s.charAt(j);

                if (arr[i][j] == 'D') {
                    finalX = i;
                    finalY = j;
                }
            }
        }

        bfs();

        System.out.println(count[finalX][finalY] == 0 ? "KAKTUS" : count[finalX][finalY]);
    }

    // . 비어있는 곳
    // * 물
    // X 돌
    // D 비버 굴
    // S 고슴도치 위치
    static void bfs() {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (arr[i][j] == '*') {
                    q.offer(new Pair(i, j, '*'));
                }
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (arr[i][j] == 'S') {
                    q.offer(new Pair(i, j, 'S'));
                }
            }
        }

        while (!q.isEmpty()) {
            Pair p = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                // 물 : 돌, 비버 굴로 이동 불가
                // 고슴도치 : 돌, 물, 다음 예정 물로 이동 불가
                if (nx >= 0 && nx < r && ny >= 0 && ny < c) {
                    if (p.c == 'S') {
                        if (arr[nx][ny] == '.' || arr[nx][ny] == 'D') {
                            count[nx][ny] = count[p.x][p.y] + 1;

                            if (arr[nx][ny] == 'D') return;

                            arr[nx][ny] = 'S';
                            q.offer(new Pair(nx, ny, p.c));
                        }
                    }

                    if (p.c == '*') {
                        if (arr[nx][ny] == '.') {
                            arr[nx][ny] = '*';
                            q.offer(new Pair(nx, ny, p.c));
                        }
                    }
                }
            }
        }
    }

    static class Pair {
        int x, y;
        char c;

        public Pair(int x, int y, char c) {
            this.x = x;
            this.y = y;
            this.c = c;
        }
    }
}
