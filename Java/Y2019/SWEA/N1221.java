package Java.Y2019.SWEA;

import java.util.*;

public class N1221 {
    static int t;
    static String[] strings, pri;
    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        t = in.nextInt();

        for (int T = 1; T <= t; T++) {
            list.clear();
            String qnum = in.next();
            int qlen = in.nextInt();

            strings = new String[qlen];
            for (int i = 0; i < qlen; i++) {
                String str = in.next();
                strings[i] = str;

                if (str.equals("ZRO")) {
                    list.add(0);
                } else if (str.equals("ONE")) {
                    list.add(1);
                } else if (str.equals("TWO")) {
                    list.add(2);
                } else if (str.equals("THR")) {
                    list.add(3);
                } else if (str.equals("FOR")) {
                    list.add(4);
                } else if (str.equals("FIV")) {
                    list.add(5);
                } else if (str.equals("SIX")) {
                    list.add(6);
                } else if (str.equals("SVN")) {
                    list.add(7);
                } else if (str.equals("EGT")) {
                    list.add(8);
                } else if (str.equals("NIN")) {
                    list.add(9);
                }
            }

            Collections.sort(list);

            pri = new String[list.size()];
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) == 0) {
                    pri[i] = "ZRO";
                } else if (list.get(i) == 1) {
                    pri[i] = "ONE";
                } else if (list.get(i) == 2) {
                    pri[i] = "TWO";
                } else if (list.get(i) == 3) {
                    pri[i] = "THR";
                } else if (list.get(i) == 4) {
                    pri[i] = "FOR";
                } else if (list.get(i) == 5) {
                    pri[i] = "FIV";
                } else if (list.get(i) == 6) {
                    pri[i] = "SIX";
                } else if (list.get(i) == 7) {
                    pri[i] = "SVN";
                } else if (list.get(i) == 8) {
                    pri[i] = "EGT";
                } else if (list.get(i) == 9) {
                    pri[i] = "NIN";
                }
            }

            System.out.println("#" + T);
            for (int i = 0; i < pri.length; i++) {
                System.out.print(pri[i] + " ");
            }
            System.out.println();
        }
    }
}
