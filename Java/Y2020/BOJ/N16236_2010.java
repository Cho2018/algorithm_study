import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int sx, sy;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    static class Pair {
        int x, y, s_size, eat_count, dis;

        public Pair(int x, int y, int s_size, int eat_count, int dis) {
            this.x = x;
            this.y = y;
            this.s_size = s_size;
            this.eat_count = eat_count;
            this.dis = dis;
        }
    }
    
    static void ft_init() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
            	visited[i][j] = false;
            }
        }
    }
    
    static void ft_solve() {
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(sx, sy, 2, 0, 0)); // 아기 상어 처음 크기 = 2
        visited[sx][sy] = true;

        int answer = 0; // 스스로의 힘으로 물고기 잡아먹는 시간
        
        while (!q.isEmpty()) {
            int eatX = 99, eatY = 99; // 먹이감 위치
            int s_size = 0, eat_count = 0, dis = 0;
            int size = q.size();

            for (int j = 0; j < size; j++) {
                Pair p = q.poll();

                for (int d = 0; d < 4; d++) {
                    int nx = p.x + dx[d];
                    int ny = p.y + dy[d];

                    if (nx < 0 || nx >= n || ny < 0 || ny >= n || visited[nx][ny]) continue;
                    if (arr[nx][ny] > p.s_size) continue; // 아기 상어보다 크기가 크면 못 지나감

                    // 아기 상어와 크기 같으면, 먹지는 못하고 이동만 가능
                    // 이동은 칸 수 세는 거임
                    q.offer(new Pair(nx, ny, p.s_size, p.eat_count, p.dis + 1));
                    visited[nx][ny] = true;

                    // 아기 상어보다 크기가 작은
                    if (arr[nx][ny] != 0 && arr[nx][ny] != p.s_size) {
                        // 조건에 따라서 
                    	// 위 -> 왼쪽
                        if (nx < eatX) {
                            eatX = nx;
                            eatY = ny;
                            s_size = p.s_size;
                            eat_count = p.eat_count;
                            dis = p.dis + 1;
                        } else if (nx == eatX) {
                            if (ny < eatY) {
                                eatX = nx;
                                eatY = ny;
                                s_size = p.s_size;
                                eat_count = p.eat_count;
                                dis = p.dis + 1;
                            }
                        }
                    }
                }
            }

            if (eatX != 99) {
                eat_count++;

                if (eat_count == s_size) { // 아기 상어 크기와 먹은 횟수가 같으면 아기 상어 크기 증가
                    s_size++;
                    eat_count = 0; // 초기화
                }

                arr[sx][sy] = 0; // 아기 상어 이동으로 초기화
                arr[eatX][eatY] = 9; // 먹이 먹은 결과 아기 상어의 현 위치
                sx = eatX;
                sy = eatY;
                
                answer += dis; // 이동 거리 / 1초에 한 칸 움직이니

                q.clear();
                ft_init();

                // 재탐색 시작
                q.offer(new Pair(eatX, eatY, s_size, eat_count, 0));
                visited[eatX][eatY] = true;
            }
        }

        System.out.println(answer);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        n = Integer.parseInt(bf.readLine()); // 공간의 크기

        arr = new int[n][n];
        visited = new boolean[n][n];

        // 빈 칸 : 0
        // 칸에 있는 물고기의 크기 : 1 ~ 6
        // 아기 상어 위치 : 9
        for (int i = 0; i < n; i++) {
        	st = new StringTokenizer(bf.readLine());
        	
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                if (arr[i][j] == 9) { // 아기 상어
                    sx = i;
                    sy = j;
                }
            }
        }

        ft_solve();
    }
}
