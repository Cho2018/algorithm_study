package Java.Y2019.BOJ.stack;

import java.util.*;

//시간 초과
public class N17298 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(in.nextInt());
        }

        for (int i = 0; i < N; i++) {
            int cnt = 0;
            for (int j = i + 1; j < N; j++) {
                if (list.get(i) < list.get(j)) {
                    cnt++;
                    System.out.print(list.get(j) + " ");
                    break;
                }
            }

            if (cnt == 0) {
                System.out.print(-1 + " ");
            }
        }
    }
}
