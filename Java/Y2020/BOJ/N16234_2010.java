import java.io.*;
import java.util.*;

public class Main {
    static int n, l, r;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    
    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    static boolean ft_isMoveable(Pair p, int nx, int ny) {
        if (0 <= nx && nx < n && 0 <= ny && ny < n && !visited[nx][ny]) {
            // 인구 수 차이
            int cha = Math.abs(arr[p.x][p.y] - arr[nx][ny]);

            if (l <= cha && cha <= r) {
            	return true;
            }
        }

        return false;
    }
    
    // 연합 확인
    static int ft_solve(int x, int y) {
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(x, y));

        ArrayList<Pair> group = new ArrayList<>();
        group.add(new Pair(x, y));

        visited[x][y] = true;
        
        int sum = arr[x][y];

        while (!q.isEmpty()) {
            Pair p = q.poll();

            for (int d = 0; d < 4; d++) {
                int nx = p.x + dx[d];
                int ny = p.y + dy[d];

                if (ft_isMoveable(p, nx, ny)) {
                    q.offer(new Pair(nx, ny));
                    group.add(new Pair(nx, ny));
                    visited[nx][ny] = true;
                    sum += arr[nx][ny];
                }
            }
        }

        // 연합이 있으면, 연합의 인구 수 변경
        if (group.size() != 1) {
            int people = sum / group.size();

            for (Pair each : group) {
                arr[each.x][each.y] = people;
            }
        }

        // 연합이 없으면
        return group.size();
    }

    public static void main(String[] args) throws IOException {
    	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;

    	st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken()); // 땅 크기
        l = Integer.parseInt(st.nextToken()); // 국경선 공유하는 두 나라 인구 차이 이것 이상
        r = Integer.parseInt(st.nextToken()); // 이것 이하

        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
        	st = new StringTokenizer(bf.readLine());
        	
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken()); // 초기 인구 수
            }
        }

        int answer = 0; // 인구 이동 횟수
        
        while (true) {
        	boolean flag = false;
            visited = new boolean[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j] && ft_solve(i, j) > 1) {
                        flag = true;
                    }
                }
            }

            if (flag) {
                answer++;
            } else {
                break;
            }
        }

        System.out.println(answer);
    }
}
