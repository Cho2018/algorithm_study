package Java.Y2020.BOJ;

import java.io.*;
import java.util.*;

public class N15686_2008 {
    static int n, m;
    static ArrayList<Pair> home_list;
    static ArrayList<Pair> chicken_list;
    static Stack<Pair> selected_stack;
    static int answer = Integer.MAX_VALUE;

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void ft_cal() {
        int sum = 0;

        for (Pair home : home_list) {
            int min = Integer.MAX_VALUE;

            for (Pair chicken : selected_stack) {
                int distance = Math.abs(chicken.x - home.x) + Math.abs(chicken.y - home.y);
                min = Math.min(min, distance);
            }

            sum += min;

            if (sum > answer) return;
        }

        answer = Math.min(answer, sum);
    }

    // M개의 치킨집을 선택
    static void ft_select(int count, int index) {
        if (count == m) {
            ft_cal();
            return;
        }

        for (int i = index; i < chicken_list.size(); i++) {
            selected_stack.push(chicken_list.get(i));
            ft_select(count + 1, i + 1);
            selected_stack.pop();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        home_list = new ArrayList<>();
        chicken_list = new ArrayList<>();
        selected_stack = new Stack<>();

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(bf.readLine());

            for (int j = 1; j <= n; j++) {
                int data = Integer.parseInt(st.nextToken());

                // 0 : 빈 칸
                // 1 : 집
                // 2 : 치킨집
                if (data == 1) {
                    home_list.add(new Pair(i, j));
                } else if (data == 2) {
                    chicken_list.add(new Pair(i, j));
                }
            }
        }

        ft_select(0, 0);

        System.out.println(answer);
    }
}
