package Java.Y2019.BOJ.graph;

import java.util.*;

//런타임 에러
public class N1697 {
    static int[] visited = new int[100001];
    static int N, K;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        K = in.nextInt();

        bfs();
    }

    static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(N);
        visited[N] = 1;

        while (!queue.isEmpty()) {
            N = queue.poll();

            if (N == K) {
                break;
            }

            if (N + 1 <= 100000 & visited[N + 1] == 0) {
                queue.offer(N + 1);
                visited[N + 1] = visited[N] + 1;
            }

            if (N - 1 >= 0 && visited[N - 1] == 0) {
                queue.offer(N - 1);
                visited[N - 1] = visited[N] + 1;
            }

            if (N * 2 <= 100000 && visited[N * 2] == 0) {
                queue.offer(N * 2);
                visited[N * 2] = visited[N] + 1;
            }
        }

        System.out.println(visited[K] - 1); //0이 아닌 1에서 시작해서 -1 해주기
    }
}
