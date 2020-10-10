package SWEA;

import java.io.*;
import java.util.*;

public class N2117_2010_re {
	static int N, M;
	static int[][] arr;
	static boolean[][] visited;
	static Queue<Pair> q;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int answer;
	
	static class Pair {
		int x, y;
		
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int ft_getCost(int k) {
		return k * k + (k - 1) * (k - 1);
	}
	
	static void ft_bfs(int x, int y) {
		q.offer(new Pair(x, y));
		visited[x][y] = true;
		
		int k = 1;
		int homeCount = arr[x][y] == 1? 1 : 0;
		if (ft_getCost(k) <= homeCount * M) {
			answer = Math.max(answer, homeCount);
		}
		
		while (!q.isEmpty()) {
			k++;
			int size = q.size();
			
			for (int i = 0; i < size; i++) { 
				Pair p = q.poll();
				
				for (int d = 0; d < 4; d++) {
					int nx = p.x + dx[d];
					int ny = p.y + dy[d];
					
					if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny]) {
						continue;
					}
					
					if (arr[nx][ny] == 1) {
						homeCount++;
					}
					
					q.offer(new Pair(nx, ny));
					visited[nx][ny] = true;
				}
				
				if (ft_getCost(k) <= homeCount * M) {
					answer = Math.max(answer, homeCount);
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(bf.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(bf.readLine());
			N = Integer.parseInt(st.nextToken()); // 정사각형 크기
			M = Integer.parseInt(st.nextToken()); // 한 집당 지불 금액
			
			arr = new int[N][N];
			answer = 0;
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(bf.readLine());
				
				for (int j = 0; j < N; j++) { // 1 : 집
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					visited = new boolean[N][N];
					q = new LinkedList<>();
					ft_bfs(i, j);
				}
			}
			
			System.out.println("#" + tc + " " + answer);
		}
	}
}
