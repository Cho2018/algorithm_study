import java.util.*;

public class Main {
    static int n, m;
    static int[][] arr;
    static int[][] copy;
    static ArrayList<Pair> list = new ArrayList<>();
    static int[][] d = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static int result;

    static class Pair {
        int x, y, type, dir;

        public Pair(int x, int y, int type, int dir) {
            this.x = x;
            this.y = y;
            this.type = type;
            this.dir = dir;
        }
    }
    
    static void init() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                copy[i][j] = arr[i][j];
            }
        }
    }
    
    static void check(Pair p) {
        int nx = p.x;
        int ny = p.y;

        switch (p.type) {
            case 1:
                while (true) {
                    nx += d[p.dir][0];
                    ny += d[p.dir][1];

                    if (nx < 0 || ny < 0 || nx >= n || ny >= m) break;

                    if (copy[nx][ny] == 0) copy[nx][ny] = -1;
                    else if (copy[nx][ny] == 6) break;
                }
                break;
            case 2:
                for (int i = 0; i < 3; i += 2) {
                    nx = p.x;
                    ny = p.y;

                    while (true) {
                        nx += d[(p.dir + i) % 4][0];
                        ny += d[(p.dir + i) % 4][1];

                        if (nx < 0 || ny < 0 || nx >= n || ny >= m) break;

                        if (copy[nx][ny] == 0) copy[nx][ny] = -1;
                        else if (copy[nx][ny] == 6) break;
                    }
                }
                break;
            case 3:
                for (int i = 0; i < 2; i++) {
                    nx = p.x;
                    ny = p.y;

                    while (true) {
                        nx += d[(p.dir + i) % 4][0];
                        ny += d[(p.dir + i) % 4][1];

                        if (nx < 0 || ny < 0 || nx >= n || ny >= m) break;

                        if (copy[nx][ny] == 0) copy[nx][ny] = -1;
                        else if (copy[nx][ny] == 6) break;
                    }
                }
                break;
            case 4:
                for (int i = 0; i < 3; i++) {
                    nx = p.x;
                    ny = p.y;

                    while (true) {
                        nx += d[(p.dir + i) % 4][0];
                        ny += d[(p.dir + i) % 4][1];

                        if (nx < 0 || ny < 0 || nx >= n || ny >= m) break;

                        if (copy[nx][ny] == 0) copy[nx][ny] = -1;
                        else if (copy[nx][ny] == 6) break;
                    }
                }
                break;
            case 5:
                for (int i = 0; i < 4; i++) {
                    nx = p.x;
                    ny = p.y;

                    while (true) {
                        nx += d[(p.dir + i) % 4][0];
                        ny += d[(p.dir + i) % 4][1];

                        if (nx < 0 || ny < 0 || nx >= n || ny >= m) break;

                        if (copy[nx][ny] == 0) copy[nx][ny] = -1;
                        else if (copy[nx][ny] == 6) break;
                    }
                }
                break;
        }
    }
    
    static void solve(int index) {
        if (index >= list.size()) {
            init();

            for (Pair p : list) {
                check(p);
            }

            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (copy[i][j] == 0) {
                        count++;
                    }
                }
            }

            result = Math.min(result, count);

            return;
        }
        
        for (int i = 0; i < 4; i++) {
            list.get(index).dir = i;
            solve(index + 1);
        }
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        m = in.nextInt();

        arr = new int[n][m];
        copy = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = in.nextInt();

                if (arr[i][j] > 0 && arr[i][j] < 6) { // cctv
                    list.add(new Pair(i, j, arr[i][j], 0));
                }
            }
        }

        result = 100;

        solve(0);

        System.out.println(result);
    }
}
