package Java.Y2020.BOJ;

import java.io.*;
import java.util.*;

public class N1697 {
    static int n, k;
    static int[] arr = new int[100001];
    static boolean[] visited = new boolean[100001];
    static Queue<Integer> qx = new LinkedList<>();
    static int[] dx = {-1, 1, 2};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        bfs(n);

        System.out.println(arr[k]);
    }

    static void bfs(int x) {
        qx.offer(x);
        visited[x] = true;

        while (!qx.isEmpty()) {
            int tx = qx.poll();

            for (int i = 0; i < 3; i++) {
                int nx;

                if (i == 2) {
                    nx = tx * dx[i];
                } else {
                    nx = tx + dx[i];
                }

                if (nx >= 0 && nx < 100001) {
                    if (visited[nx] == false) {
                        qx.offer(nx);
                        visited[nx] = true;
                        arr[nx] = arr[tx] + 1;
                    }
                }
            }
        }
    }
}
