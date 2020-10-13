package SWEA;

import java.io.*;
import java.util.*;

public class N4014_2010_re {
	static int N, X;
	static int[][] arr = new int[20][20];
	static int[][] arr2 = new int[20][20];
	static int answer;
	
	static boolean ft_isBuild(int[][] arr, int index) {
		int count = 1;
		int cur = arr[index][0];
		
		for (int i = 1; i < N; i++) {
			if (cur == arr[index][i]) {
				count++;
			} else if (arr[index][i] - 1 == cur) {
				if (count < X) { // 경사로 길이보다 작음 => 경사로 건설 못함 
					return false;
				} else {
					count = 1;
					cur = arr[index][i];
				}
			} else if (cur - arr[index][i] == 1) {
				if (N < i + X) { // 지도 범위 벗어남
					return false;
				}
				
				// **review
				for (int j = 1; j < X; j++) {
					if (cur - arr[index][++i] != 1) {
						return false;
					}
				}
				
				count = 0;
				cur = arr[index][i];
			} else { // 높이 차가 1보다 큼
				return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(bf.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(bf.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			answer = 0;
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(bf.readLine());
				
				for (int j = 0; j < N; j++) {
					int value = Integer.parseInt(st.nextToken());
					arr[i][j] = arr2[j][i] = value;
				}
			}
			
			for (int i = 0; i < N; i++) {
				if (ft_isBuild(arr, i)) {
					answer++;
				}
				
				if (ft_isBuild(arr2, i)) {
					answer++;
				}
			}
			
			System.out.println("#" + tc + " " + answer);
		}
	}
}
