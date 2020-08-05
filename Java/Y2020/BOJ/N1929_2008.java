package Java.Y2020.BOJ;

import java.io.*;
import java.util.*;

public class N1929_2008 {
    static boolean ft_is_prime(int nbr) {
        int i = 5;

        if (nbr == 1) return false;
        else if (nbr <= 3) return true;
        else if (nbr % 2 == 0 || nbr % 3 == 0) return false;

        while (i * i <= nbr) {
            if (nbr % i == 0 || nbr % (i + 2) == 0) return false;
            i += 6;
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        for (int i = m; i <= n; i++) {
            if (ft_is_prime(i)) sb.append(i).append("\n");
        }

        System.out.println(sb);
    }
}
