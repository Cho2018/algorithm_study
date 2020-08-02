package Java.Y2020.BOJ;

import java.io.*;
import java.util.*;

public class N1181_2008 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        HashSet<String> hashSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            hashSet.add(bf.readLine());
        }

        ArrayList<String> list = new ArrayList<>(hashSet);
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                }
                return o1.length() - o2.length();
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i)).append("\n");
        }

        System.out.println(sb);
    }
}
