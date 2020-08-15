package Java.Y2020.BOJ;

import java.io.*;
import java.util.*;

public class N1697_2008 {
    static int n, k;
    static int[] arr = new int[100001];
    static boolean[] visited = new boolean[100001];
    static int[] dx = {-1, 1, 2};

    static void ft_bfs(int x) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(x);
        visited[x] = true;

        while (!queue.isEmpty()) {
            int tx = queue.poll();

            for (int i = 0; i < 3; i++) {
                int nx;

                if (i == 2) {
                    nx = tx * dx[i];
                } else {
                    nx = tx + dx[i];
                }

                if (nx >= 0 && nx < 100001) {
                    if (visited[nx] == false) {
                        queue.offer(nx);
                        visited[nx] = true;
                        arr[nx] = arr[tx] + 1;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        ft_bfs(n);

        System.out.println(arr[k]);
    }
}
