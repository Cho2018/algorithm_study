package Java.Y2020.BOJ;

import java.io.*;
import java.util.*;

public class N1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(bf.readLine()));
        }

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            stack.push(i);
            sb.append("+").append('\n');

            while (!stack.isEmpty() && !list.isEmpty() && stack.peek().equals(list.get(0))) {
                stack.pop();
                sb.append("-").append('\n');
                list.remove(0);
            }
        }

        if (!stack.isEmpty()) {
            sb.setLength(0);
            sb.append("NO");
        }

        System.out.println(sb);
    }
}
