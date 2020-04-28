package Java.Y2019.BOJ.stack;

import java.util.*;

public class N10828 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        Stack<Integer> st = new Stack<Integer>();

        /*for (int i = 0; i <= N; i++) {
            String str = in.next();

            if (str.equals("pop")) {
                if (st.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(st.pop());
                }
            }

            else if (str.equals("top")) {
                if (st.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(st.peek());
                }
            }

            else if (str.equals("size")) {
                System.out.println(st.size());
            }

            else if (str.equals("empty")) {
                if (st.isEmpty()) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            }

            else if (str.equals("push")) {
                int x = in.nextInt();
                st.push(x);
            }
        }*/

        for (int i = 0; i < N; i++) {
            String str = in.next();

            if (str.equals("push")) {
                int x = in.nextInt();
                st.push(x);
            } else if (str.equals("pop")) {
                System.out.println(st.isEmpty() ? -1 : st.pop());
            } else if (str.equals("size")) {
                System.out.println(st.size());
            } else if (str.equals("empty")) {
                System.out.println(st.isEmpty() ? 1 : 0);
            } else if (str.equals("top")) {
                System.out.println(st.isEmpty() ? -1 : st.peek());
            }
        }
    }
}
