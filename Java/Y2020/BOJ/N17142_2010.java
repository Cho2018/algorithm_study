import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int count = 0;
    static int[][] arr;
    static ArrayList<Pair> virus = new ArrayList<>();
    static boolean[] check;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int answer = Integer.MAX_VALUE; // 최소 시간 구하는

    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    static int[][] ft_copy() {
        int[][] tempArr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                tempArr[i][j] = arr[i][j];
            }
        }

        for (int i = 0; i < virus.size(); i++) {
            if (!check[i]) { // 선택되지 않은
                Pair p = virus.get(i);
                tempArr[p.x][p.y] = 3;
            }
        }

        return tempArr;
    }
    
    static boolean ft_isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < n;
    }
    
    static void ft_bfs(int[][] arr, int count) {
        Queue<Pair> q = new LinkedList<>();

        for (int i = 0; i < virus.size(); i++) {
            if (check[i]) {
                q.offer(virus.get(i));
            }
        }

        int time = 0;
        while (!q.isEmpty()) {
            if (answer <= time) break;

            int size = q.size();
            for (int i = 0; i < size; i++) {
                Pair p = q.poll();

                for (int d = 0; d < 4; d++) {
                    int nx = p.x + dx[d];
                    int ny = p.y + dy[d];

                    if (!ft_isValid(nx, ny) || arr[nx][ny] == 1 || arr[nx][ny] == 2) {
                        continue;
                    }

                    if (arr[nx][ny] == 0) count--;
                    arr[nx][ny] = 2;
                    q.offer(new Pair(nx, ny));
                }
            }

            time++;

            if (count == 0) {
                answer = time;
                return;
            }
        }
    }

    static void ft_comb(int depth, int start) {
        if (depth == m) { // m개 선택 완료
            int[][] tempArr = ft_copy();
            ft_bfs(tempArr, count);
            return;
        }

        for (int i = start; i < virus.size(); i++) {
            check[i] = true;
            ft_comb(depth + 1, i + 1);
            check[i] = false;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken()); // 연구소 크기
        m = Integer.parseInt(st.nextToken()); // 바이러스 개수

        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());

            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                // 빈 칸 : 0
                // 벽 : 1
                // 바이러스를 놓을 수 있는 : 2
                if (arr[i][j] == 2) virus.add(new Pair(i, j));
                if (arr[i][j] == 0) count++; // 바이러스가 퍼질 수 있는 공간 카운트
            }
        }

        check = new boolean[virus.size()]; // 위치 선택 / m개

        if (count != 0) {
            ft_comb(0, 0);
        } else {
            answer = 0;
        }

        System.out.println((answer == Integer.MAX_VALUE)? -1 : answer);
    }
}
