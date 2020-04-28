package Java.Y2019.SWEA;

import java.util.*;

public class N1208 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        for (int t = 1; t <= 10; t++) {
            int n = in.nextInt();

            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < 100; i++) {
                int adding = in.nextInt();
                list.add(adding);
            }

            //max 찾고 min 찾은 다음 빼기 하고 더하기 해
            //다시 반복
            //수 세서 n 이랑 같을 때까지만 하도록
            while (n-- != 0) {
                Collections.sort(list);

                int x = list.get(list.size() - 1);
                int y = list.get(0);

                if ((x - y) <= 1) {
                    break;
                } else {
                    x = x - 1;
                    list.remove(list.size() - 1);
                    list.add(list.size() - 1, x);

                    y = y + 1;
                    list.remove(0);
                    list.add(0, y);
                }
            }

            Collections.sort(list);

            int result = list.get(list.size() - 1) - list.get(0);

            System.out.println("#" + t + " " + result);
        }
    }
}
