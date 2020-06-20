package Java.Y2020.BOJ;

import java.io.*;
import java.util.*;

public class N5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bf.readLine());
        while (t-- > 0) {
            String p = bf.readLine();
            char[] orders = p.toCharArray();

            int n = Integer.parseInt(bf.readLine());

            String input = bf.readLine();
            input = input.substring(1, input.length() - 1);

            // 1. n 으로 1차 진행
            StringTokenizer st;
            if (n != 0) {
                st = new StringTokenizer(input, ",");
            } else {
                if (p.contains("D")) {
                    System.out.println("error");
                } else {
                    System.out.println("[]");
                }

                continue;
            }

            Deque<String> deque = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                deque.offer(st.nextToken());
            }

            // 2. 명령어로 2차 진행

            // true : 정방향 => 앞 지움
            // false : 역방향 => 뒤 지움
            boolean direction = true;
            boolean flag = false;
            for (int i = 0; i < orders.length; i++) {
                if (orders[i] == 'R') {
                    direction = !direction;
                } else {
                    if (deque.isEmpty()) {
                        flag = true;
                        break;
                    }

                    if (direction) {
                        deque.poll();
                    } else {
                        deque.pollLast();
                    }
                }
            }

            StringBuilder sb = new StringBuilder();
            if (!flag) {
                sb.append("[");

                if (direction) {
                    while (deque.size() > 1) {
                        sb.append(deque.poll() + ",");
                    }
                } else {
                    while (deque.size() > 1) {
                        sb.append(deque.pollLast() + ",");
                    }
                }

                if (deque.size() != 0) {
                    sb.append(deque.poll());
                }

                sb.append("]");
                System.out.println(sb);
            } else {
                System.out.println("error");
            }
        }
    }
}
