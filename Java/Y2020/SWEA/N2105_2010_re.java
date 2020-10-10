package SWEA;

import java.io.*;
import java.util.*;

public class N2105_2010_re {
	static int N, count;
	static int[][] arr;
	static boolean[][] visited;
	static HashSet<Integer> set;
	static int[] dx = {1, 1, -1, -1};
	static int[] dy = {1, -1, -1, 1};
	static int answer;
	
	static void ft_init() {
		set.clear();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				visited[i][j] = false;
			}
		}
	}
	
	static void ft_dfs(int x, int y, int dstX, int dstY, int dir) {
		for (int d = dir; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if (set.size() >=3 && nx == dstX && ny == dstY) {
				count = set.size();
				answer = Math.max(answer, count);
				return;
			}
			
			if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny]) {
				continue;
			}
			
			// **review
			if (set.contains(arr[nx][ny])) {
				continue;
			}
			
			set.add(arr[nx][ny]);
			visited[nx][ny] = true;
			ft_dfs(nx, ny, dstX, dstY, d);
			visited[nx][ny] = false;
			set.remove(arr[nx][ny]);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(bf.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(bf.readLine());
			
			arr = new int[N][N];
			visited = new boolean[N][N];
			set = new HashSet<>();
			answer = -1;
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(bf.readLine());
				
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i < N - 2; i++) {
				for (int j = 1; j < N - 1; j++) {
					ft_init();
					set.add(arr[i][j]);
					visited[i][j] = true;
					ft_dfs(i, j, i, j, 0);
					visited[i][j] = false;
					set.remove(arr[i][j]);
				}
			}
			
			System.out.println("#" + tc + " " + answer);
		}
	}
}
