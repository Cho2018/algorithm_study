package SWEA;

import java.io.*;
import java.util.*;

public class N5658_2010_re {
	static int N, K;
	static char[] arr;
	static HashSet<Integer> set;
	static int answer;
	
	static void ft_getPassword() {
		int pw_ten = 0;
		
		for (int i = 0; i < N; i += N / 4) {
			String pw_six = "";
			
			for (int j = i; j < i + N / 4; j++) {
				pw_six += arr[j];
			}
			
			pw_ten = Integer.parseInt(pw_six, 16);
			set.add(pw_ten);
		}
	}
	
	static void ft_rotate() {
		char temp = arr[N - 1];
		
		for (int i = N - 1; i > 0; i--) {
			arr[i] = arr[i - 1];
		}
		
		arr[0] = temp;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(bf.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(bf.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			arr = bf.readLine().toCharArray();
			set = new HashSet<>();
			answer = 0;
			
			for (int i = 0; i < N - 1; i++) {
				ft_getPassword();
				ft_rotate();
			}
			
			ArrayList<Integer> list = new ArrayList<>();
			
			for (int value : set) {
				list.add(value);
			}
			
			Collections.sort(list, Collections.reverseOrder());
			
			answer = list.get(K - 1);
			System.out.println("#" + tc + " " + answer);
		}
	}
}
