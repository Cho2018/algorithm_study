package Java.Y2020.BOJ;

import java.io.*;
import java.util.*;

public class N6603 {
    static int k;
    static int[] arr;
    static boolean[] visited;
    static int count;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while ((k = in.nextInt()) != 0) {
            arr = new int[k];

            for (int i = 0; i < k; i++) {
                arr[i] = in.nextInt();
            }

            for (int i = 0; i < k; i++) {
                count = 1;
                visited = new boolean[k];
                visited[i] = true;
                dfs(i);
            }

            System.out.println();
        }
    }

    static void dfs(int start) {
        if (count == 6) {
            for (int i = 0; i < k; i++) {
                if (visited[i] == true) {
                    System.out.print(arr[i] + " ");
                }
            }
            System.out.println();
        } else {
            for (int i = start + 1; i < k; i++) {
                count++;
                visited[i] = true;
                dfs(i);
                count--;
                visited[i] = false;
            }
        }
    }
}
