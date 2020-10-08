package SWEA;

import java.io.*;
import java.util.*;

public class N1949_2010_re {
	static int N, K;
	static boolean flag;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int answer;
	
	static void ft_dfs(int x, int y, int value, int length) {
		if (visited[x][y]) {
			return;
		}
		
		answer = Math.max(answer, length);
		
		if (value != 0) {
			visited[x][y] = true;
			
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				int current = value;
				int next = arr[nx][ny];
				
				if (current == 0 || next == 0) {
					continue;
				}
				
				if (current > next) {
					ft_dfs(nx, ny, next, length + 1);
				} 
				
				// **review
				if (!flag) {
					for (int j = 1; j <= K; j++) {
						if (next - j < current) {
							flag = true;
							ft_dfs(nx, ny, next - j, length + 1);
							flag = false;
						}
					}
				}
			}
			
			visited[x][y] = false;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(bf.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(bf.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			flag = false;
			arr = new int[10][10];
			visited = new boolean[10][10];
			answer = 0;
			
			int high = 0;
			
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(bf.readLine());
				
				for (int j = 1; j <= N; j++) {
					int value = Integer.parseInt(st.nextToken());
					arr[i][j] = value;
					high = Math.max(high, value);
				}
			}
			
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (arr[i][j] == high) {
						ft_dfs(i, j, arr[i][j], 1);
					}
				}
			}
			
			System.out.println("#" + tc + " " + answer);
		}
	}
}
