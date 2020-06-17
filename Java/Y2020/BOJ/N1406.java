package Java.Y2020.BOJ;

import java.io.*;
import java.util.*;

public class N1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        Stack lStack = new Stack();
        Stack rStack = new Stack();

        String s = bf.readLine();
        for (int i = 0; i < s.length(); i++) {
            lStack.push(s.charAt(i));
        }

        int m = Integer.parseInt(bf.readLine());
        for (int i = 0; i < m; i++) {
            String order = bf.readLine();

            if (order.startsWith("L")) {
                if (!lStack.isEmpty()) {
                    rStack.push(lStack.pop());
                }
            } else if (order.startsWith("D")) {
                if (!rStack.isEmpty()) {
                    lStack.push(rStack.pop());
                }
            } else if (order.startsWith("B")) {
                if (!lStack.isEmpty()) {
                    lStack.pop();
                }
            } else if (order.startsWith("P")) {
                String[] orders = order.split(" ");
                lStack.push(orders[1]);
            }
        }

        while (!lStack.isEmpty()) {
            rStack.push(lStack.pop());
        }

        StringBuilder sb = new StringBuilder();
        while (!rStack.isEmpty()) {
            sb.append(rStack.pop());
        }

        System.out.println(sb);
    }
}
