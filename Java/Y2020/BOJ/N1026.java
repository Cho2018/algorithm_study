package Java.Y2020.BOJ;

import java.io.*;
import java.util.*;

public class N1026 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        ArrayList<Integer> listA = new ArrayList<>();
        ArrayList<Integer> listB = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            listA.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            listB.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(listA);
        Collections.sort(listB);
        Collections.reverse(listB);

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += (listA.get(i) * listB.get(i));
        }

        System.out.println(sum);
    }
}
