package Java.Y2020.BOJ;

import java.io.*;
import java.util.*;

public class N1978_2008 {
    static boolean ft_is_prime(int nbr) {
        int i = 5;

        if (nbr == 1) return false;
        else if (nbr <= 3) return true;
        else if (nbr % 2 == 0 || nbr % 3 == 0) return false;

        while (i * i <= nbr) {
            if (nbr % i  == 0 || nbr % (i + 2) == 0) return false;
            i += 6;
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        int count = 0;

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            if (ft_is_prime(Integer.parseInt(st.nextToken()))) count++;
        }

        System.out.println(count);
    }
}
