package Java.Y2020.BOJ;

import java.util.*;

public class N6603_2008 {
    static int k;
    static int[] arr;
    static int count;
    static StringBuilder sb = new StringBuilder();

    static void ft_find(int idx, String string) {
        if (count == 6) {
            sb.append(string).append("\n");
        } else {
            for (int i = idx + 1; i < k; i++) {
                count++;
                ft_find(i, string + arr[i] + " ");
            }
        }

        count--;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while ((k = in.nextInt()) != 0) {
            arr = new int[13];

            for (int i = 0; i < k; i++) {
                arr[i] = in.nextInt();
            }

            for (int i = 0; i < k; i++) {
                count = 1;
                ft_find(i, arr[i] + " ");
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }
}
