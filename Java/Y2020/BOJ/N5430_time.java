package Java.Y2020.BOJ;

import java.io.*;
import java.util.*;

public class N5430_time {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bf.readLine());
        while (t-- > 0) {
            String p = bf.readLine();
            int n = Integer.parseInt(bf.readLine());
            String numbers = bf.readLine();
            String[] arr = numbers.split("\\[|,|\\]");

            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 1; i < arr.length; i++) {
                list.add(Integer.parseInt(arr[i]));
            }

            boolean flag = false;
            for (int i = 0; i < p.length(); i++) {
                char order = p.charAt(i);

                if (order == 'R') {
                    Collections.reverse(list);
                } else if (order == 'D') {
                    if (list.isEmpty()) {
                        flag = true;
                        break;
                    } else {
                        list.remove(0);
                    }
                }
            }

            StringBuilder sb = new StringBuilder();
            sb.append("[");

            for (int i = 0; i < list.size(); i++) {
                sb.append(list.get(i)).append(",");
            }

            System.out.println(flag == true ? "error" : sb.toString().substring(0, sb.length() - 1) + "]");
        }
    }
}
