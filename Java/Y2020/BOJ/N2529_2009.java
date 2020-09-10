package Java.Y2020.BOJ;

import java.io.*;
import java.util.*;

public class N2529_2009 {
    static int k;
    static char[] arr = new char[10]; // 부등호 : 최대 9개
    static boolean[] visited = new boolean[10]; // 숫자 : 0 ~ 9
    static ArrayList<String> list = new ArrayList<>();

    static boolean ft_check(char a, char b, char sign) {
        if (sign == '<') {
            if (a > b) {
                return false;
            }
        }

        if (sign == '>') {
            if (a < b) {
                return false;
            }
        }

        return true;
    }

    static void ft_solve(int index, String num) {
        if (index == k + 1) {
            list.add(num);
            return;
        }

        for (int i = 0; i <= 9; i++) {
            if (visited[i]) continue; // 이미 사용

            if (index == 0 || ft_check(num.charAt(index - 1), (char)(i + '0'), arr[index - 1])) {
                visited[i] = true;
                ft_solve(index + 1, num + Integer.toString(i));
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        k = Integer.parseInt(bf.readLine());

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < k; i++) {
            arr[i] = st.nextToken().charAt(0);
        }

        ft_solve(0, "");
        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        sb.append(list.get(list.size() - 1)).append("\n");
        sb.append(list.get(0));
        System.out.println(sb);
    }
}
