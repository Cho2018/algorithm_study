package Java.Y2020.BOJ;

import java.io.*;
import java.util.*;

public class N1966 {
    static int n, m;
    static ArrayList<Pair> list;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bf.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            list = new ArrayList<>();

            st = new StringTokenizer(bf.readLine());
            for (int i = 0; i < n; i++) {
                list.add(new Pair(i, Integer.parseInt(st.nextToken())));
            }

            int count = 1;
            while (true) {
                int index = list.get(0).index;
                int cost = list.get(0).cost;
                boolean flag = false;

                for (int i = 1; i < list.size(); i++) {
                    if (list.get(i).cost > cost) {
                        list.remove(0);
                        list.add(new Pair(index, cost));
                        flag = true;
                        break;
                    }
                }

                if (flag == false) {
                    if (index == m) {
                        break;
                    } else {
                        list.remove(0);
                        count++;
                    }
                }
            }

            System.out.println(count);
        }
    }

    static class Pair {
        int index;
        int cost;

        public Pair(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }
    }
}
