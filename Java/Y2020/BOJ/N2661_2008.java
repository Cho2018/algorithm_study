package Java.Y2020.BOJ;

import java.io.*;

public class N2661_2008 {
    static int n;

    static boolean ft_is_good_sequence(String str) {
        int len = str.length() / 2;

        // 마지막 1개와 그 앞의 1개의 수가 동일한지
        // 마지막 2개와 그 앞의 2개의 수가 동일한지
        // ... (n / 2)
        for (int i = 1; i <= len; i++) {
            if (str.substring(str.length() - i).equals(str.substring(str.length() - (2 * i), str.length() - i))) {
                return false;
            }
        }

        return true;
    }

    static void ft_find(String string) {
        if (string.length() == n) {
            System.out.println(string);
            System.exit(0); // 현재 실행 프로세스 강제 종료
            // return -> 다 프린트함
        } else {
            for (int i = 1; i <= 3; i++) {
                if (ft_is_good_sequence(string + i)) {
                    ft_find(string + i);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(bf.readLine());

        ft_find("");
    }
}
