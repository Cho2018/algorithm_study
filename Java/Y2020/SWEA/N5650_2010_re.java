package SWEA;

import java.io.*;
import java.util.*;

public class N5650_2010_re {
	static int N;
	static int[][] arr;
	static int[][] warmhole;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int answer;
	
	static class Pair {
		int x, y, dir;
		
		public Pair(int x, int y, int dir) {
			this.x = x;
			this.y = y;
			this.dir = dir;
		}
	}
	
	static int ft_solve(Pair ball) {
		int score = 0;
		int nx = ball.x;
		int ny = ball.y;
		int d = ball.dir;
		
		while (true) {
			nx += dx[d];
			ny += dy[d];
			
			// ��� ��ġ�� ���ƿ��� ��
			if (nx == ball.x && ny == ball.y) {
				return score;
			}
			
			// ���� �ε��� �� -> ���� ȹ�� / �ݴ� �������� ��ȯ
			if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
				score++;
				d = (d + 2) % 4;
				continue; // **review
			}
			
			int type = arr[nx][ny];
			
			switch (type) {
			    case -1 : // ��Ȧ�� ������ ��
			    	return score;
				case 0 : // ����� -> keep going
					break;
				case 1 : // 1 ~ 5 : ��� -> ���� ȹ�� / ���� ��ȯ
					score++;
					if (d == 0 || d == 1) d = (d + 2) % 4;
					else if (d == 2) d = 1;
					else if (d == 3) d = 0;
					break;
				case 2:
					score++;
					if (d == 1 || d == 2) d = (d + 2) % 4;
					else if (d == 3) d = 2;
					else if (d == 0) d = 1;
					break;
				case 3:
					score++;
					if (d == 2 || d == 3) d = (d + 2) % 4;
					else if (d == 0) d = 3;
					else if (d == 1) d = 2;
					break;
				case 4:
					score++;
					if (d == 0 || d == 3) d = (d + 2) % 4;
					else if (d == 1) d = 0;
					else if (d == 2) d = 3;
					break;
				case 5:
					score++;
					d = (d + 2) % 4;
					break;
				default : // 6 ~ 10 : ��Ȧ -> ���� ���� / �ٸ� ��Ȧ�� ����
					if (warmhole[type][0] == nx && warmhole[type][1] == ny) {
						nx = warmhole[type][2];
						ny = warmhole[type][3];
					} else {
						nx = warmhole[type][0];
						ny = warmhole[type][1];
					}
					break;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(bf.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(bf.readLine());
			
			arr = new int[N][N];
			warmhole = new int[11][4];
			answer = 0;
			
			for (int i = 0; i < 11; i++) {
				for (int j = 0; j < 4; j++) {
					warmhole[i][j] = -1;
				}
			}
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(bf.readLine());
				
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					
					// ��Ȧ
					if (arr[i][j] >= 6 && arr[i][j] <= 10) {
						if (warmhole[arr[i][j]][0] == -1) {
							warmhole[arr[i][j]][0] = i;
							warmhole[arr[i][j]][1] = j;
						} else {
							warmhole[arr[i][j]][2] = i;
							warmhole[arr[i][j]][3] = j;
						}
					}
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (arr[i][j] == 0) { // ����������� ��� ����
						for (int d = 0; d < 4; d++) { // ���� ����
							Pair ball = new Pair(i, j, d);
							int score = ft_solve(ball);
							answer = Math.max(answer, score);
						}
					}
				}
			}
			
			System.out.println("#" + tc + " " + answer);
		}
	}
}
