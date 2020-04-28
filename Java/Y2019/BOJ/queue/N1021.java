package Java.Y2019.BOJ.queue;

import java.util.*;

public class N1021 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            list.add(i);
        }

        boolean flag;
        int num, answer = 0;
        for (int i = 0; i < M; i++) {
            num = in.nextInt();

            flag = false;
            while (!flag) {
                if (list.get(0) == num) {
                    list.remove(0);
                    flag = true;
                } else {
                    if (list.indexOf(num) <= list.size() / 2) {
                        list.add(list.size() - 1, list.remove(0));
                    } else {
                        list.add(0, list.remove(list.size() - 1));
                    }

                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}
