package SWEA;

import java.io.*;
import java.util.*;

public class N2112_2010_re {
	static int D, W, K;
	static int[][] arr;
	static int[][] tempArr;
	static int answer;
	
	static boolean ft_isPass() {
		for (int j = 0; j < W; j++) {
			int value = tempArr[0][j];
			int count = 1;
			boolean flag = false; // **review
			
			for (int i = 1; i < D; i++) {
				if (tempArr[i][j] == value) {
					count++;
				} else {
					value = tempArr[i][j];
					count = 1;
				}
				
				if (count == K) {
					flag = true;
					break;
				}
			}
			
			if (!flag) {
				return false;
			}
		}
		
		return true;
	}
	
	static void ft_solve(int count, int layer) {
		if (count >= answer) { // **review
			return;
		}
		
		if (layer == D) {
			if (ft_isPass()) {
				answer = Math.min(answer, count);
			} 
			
			return;
		}
		
		// 투입 없음
		ft_solve(count, layer + 1);
		
		// A 투입
		for (int j = 0; j < W; j++) {
			tempArr[layer][j] = 0;
		}
		ft_solve(count + 1, layer + 1);
		
		// B 투입
		for (int j = 0; j < W; j++) {
			tempArr[layer][j] = 1;
		}
		ft_solve(count + 1, layer + 1);
		
		// 되돌리기
		for (int j = 0; j < W; j++) {
			tempArr[layer][j] = arr[layer][j];
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(bf.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(bf.readLine());
			D = Integer.parseInt(st.nextToken()); // 세로
			W = Integer.parseInt(st.nextToken()); // 가로
			K = Integer.parseInt(st.nextToken()); // 통과 기준
			
			arr = new int[D][W];
			tempArr = new int[D][W];
			answer = Integer.MAX_VALUE;
			
			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(bf.readLine());
				
				for (int j = 0; j < W; j++) { // A : 0 / B : 1
					int value = Integer.parseInt(st.nextToken());
					arr[i][j] = tempArr[i][j] = value;
				}
			}
			
			if (ft_isPass()) {
				answer = 0;
			} else {
				ft_solve(0, 0);
			}
			
			System.out.println("#" + tc + " " + answer);
		}
	}
}
