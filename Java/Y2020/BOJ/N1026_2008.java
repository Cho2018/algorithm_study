package Java.Y2020.BOJ;

import java.io.*;
import java.util.*;

public class N1026_2008 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        ArrayList<Integer> list_a = new ArrayList<>();
        ArrayList<Integer> list_b = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            list_a.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            list_b.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(list_a);
        Collections.sort(list_b);
        Collections.reverse(list_b);

        int answer = 0;
        for (int i = 0; i < n; i++) {
            answer += (list_a.get(i) * list_b.get(i));
        }

        System.out.println(answer);
    }
}
