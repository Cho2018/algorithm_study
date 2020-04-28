package Java.Y2019.SWEA;

import java.util.*;

public class N1215 {
    static int n, answer;
    static Character[][] graph = new Character[8][8];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean flag = true;

        for (int T = 1; T <= 10; T++) {
            n = in.nextInt();
            answer = 0;

            for (int i = 0; i < 8; i++) {
                String input = in.next();
                for (int j = 0; j < 8; j++) {
                    graph[i][j] = input.charAt(j);
                }
                in.nextLine();
            }

            //가로
            for (int i = 0; i < 8; i++) {
                for (int k = 0; k <= 8 - n; k++) {
                    flag = true;

                    for (int j = 0; j < (n / 2); j++) {
                        if (graph[i][j + k] != graph[i][n + k - j - 1]) {
                            flag = false;
                        }
                    }

                    if (flag) {
                        answer++;
                    }
                }
            }

            //세로
            for (int i = 0; i < 8; i++) {
                for (int k = 0; k <= 8 - n; k++) {
                    flag = true;

                    for (int j = 0; j < (n / 2); j++) {
                        if (graph[j + k][i] != graph[n + k - j - 1][i]) {
                            flag = false;
                        }
                    }

                    if (flag) {
                        answer++;
                    }
                }
            }

            System.out.println("#" + T + " " + answer);
        }
    }
}
