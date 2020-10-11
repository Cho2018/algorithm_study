package SWEA;

import java.io.*;
import java.util.*;

public class N5656_2010_re {
	static int N, W, H;
	static int[][] arr;
	static Queue<Pair> q;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int answer;
	
	static class Pair {
		int x, y, value;
		
		public Pair(int x, int y, int value) {
			this.x = x;
			this.y = y;
			this.value = value;
		}
	}
	
	static int[][] ft_copy(int[][] arr) {
		int[][] tempArr = new int[H][W];
		
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				tempArr[i][j] = arr[i][j];
			}
		}
		
		return tempArr;
	}
	
	static void ft_break(int x, int y, int[][] arr) {
		q = new LinkedList<>();
		q.offer(new Pair(x, y, arr[x][y]));
		arr[x][y] = 0;
		
		while (!q.isEmpty()) {
			Pair p = q.poll();
			
			for (int d = 0; d < 4; d++) {
				int nx = p.x;
				int ny = p.y;
				int num = p.value;
				
				for (int i = 0; i < num - 1; i++) {
					nx += dx[d];
					ny += dy[d];
					
					if (nx < 0 || nx >= H || ny < 0 || ny >= W) {
						break;
					}
					
					if (arr[nx][ny] == 0) {
						continue;
					}
					
					if (arr[nx][ny] > 1) {
						q.offer(new Pair(nx, ny, arr[nx][ny]));
					}
					
					arr[nx][ny] = 0;
				}
			}
		}
	}
	
	static void ft_move(int[][] arr) {
		for (int j = 0; j < W; j++) {
			for (int i = H - 1; i >= 0; i--) {
				if (arr[i][j] == 0) {
					int nx = i;
					
					while (nx > 0 && arr[nx][j] == 0) {
						nx--;
					}
					
					arr[i][j] = arr[nx][j];
					arr[nx][j] = 0;
				}
			}
		}
	}
	
	static void ft_solve(int count, int[][] arr) {
		if (count == N) {
			int remain = 0;
			
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (arr[i][j] != 0) {
						remain++;
					}
				}
			}
			
			if (answer == -1 || answer > remain) {
				answer = remain;
			}
			
			return;
		}
		
		for (int j = 0; j < W; j++) {
			int i = 0; 
			
			while (i < H) {
				if (arr[i][j] != 0) {
					break;
				}
				
				i++;
			}
			
			if (i == H) {
				continue;
			}
			
			int[][] tempArr = ft_copy(arr);
			ft_break(i, j, tempArr);
			ft_move(tempArr);
			ft_solve(count + 1, tempArr);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(bf.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(bf.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			
			arr = new int[H][W];
			answer = -1;
			
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(bf.readLine());
				
				for (int j = 0; j < W; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			ft_solve(0, arr);
			
			if (answer == -1) {
				answer = 0;
			}
			
			System.out.println("#" + tc + " " + answer);
		}
	}
}
