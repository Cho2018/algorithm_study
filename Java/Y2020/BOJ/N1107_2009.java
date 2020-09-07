package Java.Y2020.BOJ;

import java.util.*;

public class N1107_2009 {
    static ArrayList<Integer> list = new ArrayList<>();

    static int ft_check(int num) {
        int cnt = 0;

        if (num == 0) return list.contains(num)? 0 : 1;

        while (num > 0) {
            if (list.contains(num % 10)) return 0;
            num /= 10;
            cnt++;
        }

        return cnt;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();

        while (m-- > 0) list.add(in.nextInt());

        // + 또는 - 만으로 이동
        int answer = Math.abs(n - 100);

        // 이동하려고 하는 채널 : 0 ~ 50만
        // => 위 -> 아래 && 아래 -> 위 : 0 ~ 100만 확인
        // 채널은 무한대
        for (int i = 0; i <= 1000000; i++) {
            int count = ft_check(i);

            if (count > 0) {
                answer = Math.min(answer, Math.abs(n - i) + count);
            }
        }

        System.out.println(answer);
    }
}
