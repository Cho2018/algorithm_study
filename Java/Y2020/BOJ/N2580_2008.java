package Java.Y2020.BOJ;

import java.io.*;
import java.util.*;

public class N2580_2008 {
    static int[][] pann = new int[9][9];
    static ArrayList<Pair> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static boolean ft_is_possible(int x, int y, int idx) {
        // 가로, 세로 체크
        for (int i = 0; i < 9; i++) {
            if (pann[i][y] == idx || pann[x][i] == idx) {
                return false;
            }
        }

        // 3 x 3 정사각형 체크
        for (int i = (x / 3) * 3; i < (x / 3) * 3 + 3; i++) {
            for (int j = (y / 3) * 3; j < (y / 3) * 3 + 3; j++) {
                if (pann[i][j] == idx) {
                    return false;
                }
            }
        }

        return true;
    }

    static void ft_find(int count, int index) {
        if (count == list.size()) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(pann[i][j] + " ");
                }
                sb.append("\n");
            }

            System.out.println(sb);
            System.exit(0);
        }

        Pair pair = list.get(index);

        for (int i = 1; i < 10; i++) {
            if (!ft_is_possible(pair.x, pair.y, i)) continue;

            pann[pair.x][pair.y] = i;
            ft_find(count + 1, index + 1);
            pann[pair.x][pair.y] = 0;
        }
    }

    public static void main (String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());

            for (int j = 0; j < 9; j++) {
                pann[i][j] = Integer.parseInt(st.nextToken());

                if (pann[i][j] == 0) list.add(new Pair(i, j));
            }
        }

        ft_find(0, 0);
    }
}

