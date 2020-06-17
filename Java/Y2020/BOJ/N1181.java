package Java.Y2020.BOJ;

import java.io.*;
import java.util.*;

public class N1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(bf.readLine());
        }

        ArrayList<String> list = new ArrayList<>(set);

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() > o2.length()) {
                    return 1;
                } else if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                } else {
                    return -1;
                }
            }
        });

        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s).append('\n');
        }

        System.out.println(sb);
    }
}
