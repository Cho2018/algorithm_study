package Java.Y2019.SWEA;

import java.util.*;

public class N1225 {
    static int t, number, minus;
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        for (int T = 1; T <= 10; T++) {
            q.clear();
            t = in.nextInt();
            number = 0;
            minus = 1;

            for (int i = 0; i < 8; i++) {
                q.offer(in.nextInt());
            }

            while (true) {
                number = q.poll();
                number = number - minus;
                minus++;

                if (number <= 0) {
                    q.offer(0);
                    break;
                } else {
                    q.offer(number);
                }

                if (minus == 6) {
                    minus = 1;
                }
            }

            System.out.print("#" + T + " ");
            while (!q.isEmpty()) {
                System.out.print(q.poll() + " ");
            }
            System.out.println();
        }
    }
}
