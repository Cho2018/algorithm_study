package Java.Y2020.BOJ;

import java.io.*;
import java.util.*;

public class N12100_2009 {
    static int n;
    static int[][] arr;
    static int answer = 0;

    static void ft_max(int[][] arr) {
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                answer = Math.max(answer, arr[i][j]);
            }
        }
    }

    static int[][] ft_copy(int[][] arr) {
        int[][] temp = new int[n + 1][n + 1];

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                temp[i][j] = arr[i][j];
            }
        }

        return temp;
    }

    static ArrayList<Integer> ft_sum(ArrayList<Integer> line) {
        for (int i = 0; i < line.size() - 1; i++) {
            if (line.get(i).equals(line.get(i + 1))) {
                line.set(i, line.get(i) * 2);
                line.remove(i + 1);
            }
        }

        return line;
    }

    static void ft_move(int dir, int[][] arr) {
        ArrayList<Integer> line;

        // up
        // 11 21 31
        if (dir == 0) {
            for (int i = 1; i < n + 1; i++) {
                line = new ArrayList<>();

                for (int j = 1; j < n + 1; j++) {
                    if (arr[j][i] != 0) {
                        line.add(arr[j][i]);
                        arr[j][i] = 0;
                    }
                }

                line = ft_sum(line);

                for (int j = 0; j < line.size(); j++) {
                    arr[j + 1][i] = line.get(j);
                }
            }
        }

        // right
        // 13 12 11
        if (dir == 1) {
            for (int i = 1; i < n + 1; i++) {
                line = new ArrayList<>();

                for (int j = n; j >= 1; j--) {
                    if (arr[i][j] != 0) {
                        line.add(arr[i][j]);
                        arr[i][j] = 0;
                    }
                }

                line = ft_sum(line);

                for (int j = 0; j < line.size(); j++) {
                    arr[i][n - j] = line.get(j);
                }
            }
        }

        // down
        // 31 21 11
        if (dir == 2) {
            for (int i = 1; i < n + 1; i++) {
                line = new ArrayList<>();

                for (int j = n; j >= 1; j--) {
                    if (arr[j][i] != 0) {
                        line.add(arr[j][i]);
                        arr[j][i] = 0;
                    }
                }

                line = ft_sum(line);

                for (int j = 0; j < line.size(); j++) {
                    arr[n - j][i] = line.get(j);
                }
            }
        }

        // left
        // 11 12 13
        if (dir == 3) {
            for (int i = 1; i < n + 1; i++) {
                line = new ArrayList<>();

                for (int j = 1; j < n + 1; j++) {
                    if (arr[i][j] != 0) {
                        line.add(arr[i][j]);
                        arr[i][j] = 0;
                    }
                }

                line = ft_sum(line);

                for (int j = 0; j < line.size(); j++) {
                    arr[i][j + 1] = line.get(j);
                }
            }
        }
    }

    static void ft_dfs(int count, int[][] arr) {
        if (count == 5) {
            ft_max(arr);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int[][] next_arr = ft_copy(arr);
            ft_move(i, next_arr);
            ft_dfs(count + 1, next_arr);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(bf.readLine());
        arr = new int[n + 1][n + 1];

        for (int i = 1; i < n + 1; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());

            for (int j = 1; j < n + 1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        ft_dfs(0, arr);

        System.out.println(answer);
    }
}
