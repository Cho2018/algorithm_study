package Java.Y2020.BOJ;

import java.io.*;
import java.util.*;

public class N11650 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        ArrayList<Pair> list = new ArrayList<>();

        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            list.add(new Pair(x, y));
        }

        Collections.sort(list, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if (o1.x > o2.x) {
                    return 1;
                } else if (o1.x == o2.x) {
                    return Integer.compare(o1.y, o2.y);
                } else {
                    return -1;
                }
            }
        });

        StringBuilder sb = new StringBuilder();
        for (Pair p : list) {
            sb.append(p.x).append(" ").append(p.y).append('\n');
        }

        System.out.println(sb);
    }

    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
