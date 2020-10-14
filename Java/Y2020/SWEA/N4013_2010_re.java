package SWEA;

import java.io.*;
import java.util.*;

public class N4013_2010_re {
	static int K;
	static int[][] magnetic;
	static int[] action;
	static int[] score;
	static int answer;
	
	static void ft_check(int id, int dir) {
		action = new int[4];
		action[id] = dir;
		
		for (int i = id + 1; i < 4; i++) {
			if (magnetic[i][6] == magnetic[i - 1][2]) {
				action[i] = 0;
				break;
			} else {
				action[i] = action[i - 1] == 1? -1 : 1;
			}
		}
		
		for (int i = id - 1; i >= 0; i--) {
			if (magnetic[i][2] == magnetic[i + 1][6]) {
				action[i] = 0;
				break;
			} else {
				action[i] = action[i + 1] == 1? -1 : 1;
			}
		}
	}
	
	static void ft_rotate(int id) {
		int temp = 0;
		
		if (action[id] == 0) {
			return;
		} else if (action[id] == 1) { // 시계 방향
			temp = magnetic[id][7];
			
			for (int i = 7; i > 0; i--) {
				magnetic[id][i] = magnetic[id][i - 1];
			}
			
			magnetic[id][0] = temp;
		} else if (action[id] == -1) { // 반시계 방향
			temp = magnetic[id][0];
			
			for (int i = 0; i < 7; i++) {
				magnetic[id][i] = magnetic[id][i + 1];
			}
			
			magnetic[id][7] = temp;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(bf.readLine());
		
		score = new int[4];
		score[0] = 1;
		score[1] = 2;
		score[2] = 4;
		score[3] = 8;
		
		for (int tc = 1; tc <= T; tc++) {
			K = Integer.parseInt(bf.readLine()); // 회전 횟수
			
			magnetic = new int[4][8];
			answer= 0;
			
			for (int i = 0; i < 4; i++) {
				st = new StringTokenizer(bf.readLine());
				
				for (int j = 0; j < 8; j++) {
					magnetic[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(bf.readLine());
				int id = Integer.parseInt(st.nextToken()) - 1;
				int dir = Integer.parseInt(st.nextToken());
				
				ft_check(id, dir);
				
				for (int j = 0; j < 4; j++) {
					ft_rotate(j);
				}
			}
			
			for (int i = 0; i < 4; i++) {
				if (magnetic[i][0] == 1) { // S극이면
					answer += score[i];
				}
			}
			
			System.out.println("#" + tc + " " + answer);
		}
	}
}
