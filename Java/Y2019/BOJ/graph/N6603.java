package Java.Y2019.BOJ.graph;

import java.util.*;

public class N6603 {
    static int[] arr;
    static int k;
    static int count;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while ((k = in.nextInt()) != 0) {
            arr = new int[13];
            for (int i = 0; i < k; i++) {
                arr[i] = in.nextInt();
            }

            for (int i = 0; i < k; i++) {
                count = 1;
                find(i, arr[i] + " ");
            }

            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    static void find(int v, String str) {
        if (count == 6) {
            sb.append(str + "\n");
        } else {
            for (int i = v + 1; i < k; i++) {
                count++;
                find(i, str + arr[i] + " ");
            }
        }

        count--;
    }
}
