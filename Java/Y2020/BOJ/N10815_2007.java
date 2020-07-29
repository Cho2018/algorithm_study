package Java.Y2020.BOJ;

import java.io.*;
import java.util.*;

public class N10815_2007 {
    static int n, m;
    static ArrayList<Integer> list;
    static int answer;

    static void ft_find(int x) {
        answer = 0;
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (list.get(mid) == x) {
                answer = 1;
                break;
            } else if (list.get(mid) > x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(bf.readLine());
        list = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(list);

        m = Integer.parseInt(bf.readLine());
        st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            ft_find(Integer.parseInt(st.nextToken()));
            sb.append(answer).append(" ");
        }

        System.out.println(sb);
    }
}
