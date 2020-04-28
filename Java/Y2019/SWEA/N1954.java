package Java.Y2019.SWEA;

import java.util.*;

public class N1954 {
    static int t;
    static int[][] map = new int[11][11];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        t = in.nextInt();

        for (int i = 1; i <= t; i++) {
            int n = in.nextInt();

            int x = 0, y = 1, direction = 1, num = 1;
            int Length = n;

            while (n >= 0) {
                for (int a = 1; a <= n; a++) {
                    x += direction;
                    map[y][x] = num++;
                }

                if (--n < 0) {
                    break;
                }

                for (int a = 1; a <= n; a++) {
                    y += direction;
                    map[y][x] = num++;
                }

                direction *= -1;
            }

            System.out.println("#" + i);
            for (int a = 1; a <= Length; a++) {
                for (int b = 1; b <= Length; b++) {
                    System.out.print(map[a][b] + " ");
                }
                System.out.println();
            }
        }
    }
}
