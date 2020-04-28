package Java.Y2019.BOJ.stack;

import java.util.*;

public class N1874 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        //String str = "";
        StringBuilder sb = new StringBuilder();

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(in.nextInt());
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = 1; i <= n; i++) {
            stack.push(i);
            //str += "+";
            sb.append("+\n");

            while (!stack.isEmpty() && !list.isEmpty() && stack.peek().equals(list.get(0))) {
                stack.pop();
                //str += "-";
                sb.append("-\n");
                list.remove(0);
            }
        }

        if (!stack.isEmpty()) {
            sb.setLength(0);
            sb.append("NO\n");
            //System.out.println("NO");
        } /*else {
            //String[] strings = str.split("");
            //for (int i = 0; i < strings.length; i++) {
                //System.out.println(strings[i]);
            //}
        }*/
        System.out.println(sb.toString());
    }
}
