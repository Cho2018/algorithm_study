package Java.Y2020.BOJ;

import java.io.*;

public class N9663_2008 {
    static int n;
    static int[] pann;
    static int count = 0;

    static boolean ft_check(int[] pann, int row) {
        for (int i = 1; i < row; i++) {
            if (pann[i] == pann[row]) { // 같은 열 => X
                return false;
            }

            if (Math.abs(i - row) == Math.abs(pann[i] - pann[row])) { // 서로 대각선에 위치 => X
                return false;
            }
        }

        return true;
    }

    static void ft_chess(int[] pann, int row) {
        if (row == n) { // n(마지막 행)에 도달하면, 전체 퀸의 배치가 끝났다는 의미 => count 증가
            count++;
        } else {
            for (int i = 1; i <= n; i++) {
                pann[row + 1] = i;

                if (ft_check(pann, row + 1)) { // 다음 행의 i열에 퀸을 배치할 수 있는지 체크
                    ft_chess(pann, row + 1); // 다음 퀸을 배치하러 출발
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(bf.readLine());

        for (int i = 1; i <= n; i++) {
            pann = new int[n + 1];
            pann[1] = i; // 1행 i열에 퀸을 배치함
            ft_chess(pann, 1);
        }

        System.out.println(count);
    }
}
