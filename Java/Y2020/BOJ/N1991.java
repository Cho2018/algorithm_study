package Java.Y2020.BOJ;

import java.io.*;
import java.util.*;

public class N1991 {
    static int n;
    static int[][] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(bf.readLine());

        tree = new int[100][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());

            char root = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            tree[root][0] = left;
            tree[root][1] = right;
        }

        preorder('A');
        System.out.println();

        inorder('A');
        System.out.println();

        postorder('A');
    }

    static void preorder(int data) {
        System.out.print((char) data);

        if (tree[data][0] != '.') {
            preorder(tree[data][0]);
        }

        if (tree[data][1] != '.') {
            preorder(tree[data][1]);
        }
    }

    static void inorder(int data) {
        if (tree[data][0] != '.') {
            inorder(tree[data][0]);
        }

        System.out.print((char) data);

        if (tree[data][1] != '.') {
            inorder(tree[data][1]);
        }
    }

    static void postorder(int data) {
        if (tree[data][0] != '.') {
            postorder(tree[data][0]);
        }

        if (tree[data][1] != '.') {
            postorder(tree[data][1]);
        }

        System.out.print((char) data);
    }
}



