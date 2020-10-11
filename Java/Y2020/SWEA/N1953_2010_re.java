package SWEA;

import java.io.*;
import java.util.*;

public class N1953_2010_re {
	static int N, M, R, C, L;
	static int[][] arr;
	static boolean[][] visited;
	static Queue<Pair> q; // **review
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
	
	// **review
	static void ft_bfs() {
		int time = 0;
		q.offer(new Pair(R, C));
		visited[R][C] = true;
		
		while (!q.isEmpty()) {
			if (++time >= L) {
				return;
			}
			
			int size = q.size();
			
			for (int i = 0; i < size; i++) {
				Pair p = q.poll();
				int cur_type = arr[p.x][p.y];
				
				for (int d = 0; d < 4; d++) {
					int nx = p.x + dx[d];
					int ny = p.y + dy[d];
					
					if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
						continue;
					}
					
					if (visited[nx][ny] || arr[nx][ny] == 0) {
						continue;
					}
					
					// **review
					int next_type = arr[nx][ny];
					
					switch (d) {
					case 0 :
						if (cur_type == 1 || cur_type == 2 || cur_type == 4 || cur_type == 7) {
							if (next_type == 1 || next_type == 2 || next_type == 5 || next_type == 6) {
								q.offer(new Pair(nx, ny));
								visited[nx][ny] = true;
								answer++;
							}
						}
						break;
					case 1 :
						if (cur_type == 1 || cur_type == 3 || cur_type == 4 || cur_type == 5) {
							if (next_type == 1 || next_type == 3 || next_type == 6 || next_type == 7) {
								q.offer(new Pair(nx, ny));
								visited[nx][ny] = true;
								answer++;
							}
						}
						break;
					case 2 :
						if (cur_type == 1 || cur_type == 2 || cur_type == 5 || cur_type == 6) {
							if (next_type == 1 || next_type == 2 || next_type == 4 || next_type == 7) {
								q.offer(new Pair(nx, ny));
								visited[nx][ny] = true;
								answer++;
							}
						}
						break;
					case 3 :
						if (cur_type == 1 || cur_type == 3 || cur_type == 6 || cur_type == 7) {
							if (next_type == 1 || next_type == 3 || next_type == 4 || next_type == 5) {
								q.offer(new Pair(nx, ny));
								visited[nx][ny] = true;
								answer++;
							}
						}
						break;
					}
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
			N = Integer.parseInt(st.nextToken()); // 지도 크기
			M = Integer.parseInt(st.nextToken()); // 지도 크기
			R = Integer.parseInt(st.nextToken()); // 맨홀 위치
			C = Integer.parseInt(st.nextToken()); // 맨홀 위치
			L = Integer.parseInt(st.nextToken()); // 소요 시간
			
			arr = new int[N][M];
			visited = new boolean[N][M];
			q = new LinkedList<>();
			answer = 1;
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(bf.readLine());
				
				for (int j = 0; j < M; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			ft_bfs();
			
			System.out.println("#" + tc + " " + answer);
		}
	}
}
