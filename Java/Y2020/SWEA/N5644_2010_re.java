package SWEA;

import java.io.*;
import java.util.*;

public class N5644_2010_re {
	static int M, A;
	static int[][] user;
	static int[][] move;
	static int[][] bc;
	static int[] dx = {0, 0, 1, 0, -1};
	static int[] dy = {0, -1, 0, 1, 0};
	static int answer;
	
	static void ft_charge() {
		ArrayList<Integer> aList = new ArrayList<>();
		ArrayList<Integer> bList = new ArrayList<>();
		
		for (int i = 0; i < A; i++) {
			if (Math.abs(user[0][0] - bc[i][0]) + Math.abs(user[0][1] - bc[i][1]) <= bc[i][2]) {
				aList.add(i);
			}
			
			if (Math.abs(user[1][0] - bc[i][0]) + Math.abs(user[1][1] - bc[i][1]) <= bc[i][2]) {
				bList.add(i);
			}
		}
		
		int aSize = aList.size();
		int bSize = bList.size();
		int ap = 0;
		int bp = 0;
		int max = 0;
		
		if (aSize == 0 && bSize == 0) {
			return;
		} else if (aSize == 0) {
			for (int index : bList) {
				int sum = bc[index][3];
				bp = Math.max(bp, sum);
			}
		} else if (bSize == 0) {
			for (int index : aList) {
				int sum = bc[index][3];
				ap = Math.max(ap, sum);
			}
		} else {
			for (int a : aList) {
				for (int b : bList) {
					int sum = 0;
					
					if (a == b) {
						sum = bc[a][3];
						
						if (sum > max) {
							max = sum;
							ap = bc[a][3] / 2;
							bp = bc[a][3] / 2;
						}
					} else {
						sum = bc[a][3] + bc[b][3];
						
						if (sum > max) {
							max = sum;
							ap = bc[a][3];
							bp = bc[b][3];
						}
					}
				}
			}
		}
		
		answer += ap + bp;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(bf.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(bf.readLine());
			M = Integer.parseInt(st.nextToken()); // 총 이동 시간
			A = Integer.parseInt(st.nextToken()); // BC의 개수
			
			user = new int[2][2]; // 두 사용자의 현재 위치 담는
			user[0][0] = 1;
			user[0][1] = 1;
			user[1][0] = 10;
			user[1][1] = 10;
			
			move = new int[2][M + 1]; // 두 사용자의 이동 궤적을 담는
			bc = new int[A][4]; // BC의 정보 담는
			answer = 0;
			
			for (int i = 0; i < 2; i++) {
				st = new StringTokenizer(bf.readLine());
				
				for (int j = 0; j < M; j++) {
					move[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 위치, 충전 범위, 처리량
			for (int i = 0; i < A; i++) {
				st = new StringTokenizer(bf.readLine());
				
				for (int j = 0; j < 4; j++) {
					bc[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i <= M; i ++) { // 0초부터 충전 가능
				ft_charge();
				user[0][0] += dx[move[0][i]];
				user[0][1] += dy[move[0][i]];
				user[1][0] += dx[move[1][i]];
				user[1][1] += dy[move[1][i]];
			}
			
			System.out.println("#" + tc + " " + answer);
		}
	}
}
