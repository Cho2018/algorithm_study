package Java.Y2020.BOJ;

import java.io.*;
import java.util.*;

public class N1707 {
    static int v, e;
    static int x, y;
    static ArrayList<ArrayList<Integer>> arr;
    static int[] group;
    static int RED = 1, BLUE = -1;
    static String answer;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(bf.readLine());
        for (int t = 0; t < k; t++) {
            answer = "YES";

            StringTokenizer st = new StringTokenizer(bf.readLine());
            v = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());

            arr = new ArrayList<>();

            for (int i = 0; i < v; i++) {
                arr.add(new ArrayList<>());
            }

            for (int i = 0; i < e; i++) {
                st = new StringTokenizer(bf.readLine());
                x = Integer.parseInt(st.nextToken()) - 1;
                y = Integer.parseInt(st.nextToken()) - 1;

                arr.get(x).add(y);
                arr.get(y).add(x);
            }

            group = new int[v];
            for (int i = 0; i < v; i++) {
                if (group[i] == 0) {
                    if (!bfs(i)) break;
                }
            }

            System.out.println(answer);
        }
    }

    static boolean bfs(int n) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(n);
        group[n] = RED;

        while (!q.isEmpty()) {
            int temp = q.poll();

            for (Integer i : arr.get(temp)) {
                if (group[temp] == group[i]) {
                    answer = "NO";
                    return false;
                }

                if (group[i] == 0) {
                    q.offer(i);
                    group[i] = group[temp] * (-1);
                }
            }
        }

        return true;
    }
}
