package Java.Y2020.BOJ;

import java.io.*;
import java.util.*;

public class N10867 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        HashSet<Integer> set = new HashSet<>();

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        ArrayList<Integer> list = new ArrayList<>(set);

        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i)).append(" ");
        }

        System.out.println(sb);
    }
}
