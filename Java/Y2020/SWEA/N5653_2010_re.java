package SWEA;

import java.io.*;
import java.util.*;

public class N5653_2010_re {
	static int N, M, K;
	static int ARR_SIZE = 1000;
	static int CORRECTION_VALUE = 400;
	static int[][] arr;
	static boolean[][] visited;
	static Queue<Pair> q;
	static PriorityQueue<Pair> pq;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	static class Pair implements Comparable<Pair> {
		int x, y, life, start, end;
		
		public Pair(int x, int y, int life, int start, int end) {
			this.x = x;
			this.y = y;
			this.life = life;
			this.start = start;
			this.end = end;
		}
		
		public int compareTo(Pair o) {
			return o.life - this.life;
		}
	}
	
	static void ft_isAlive(int time) {
		int size = q.size();
		
		for (int i = 0; i < size; i++) {
			Pair pair = q.poll();
			
			if (time <= pair.start) { // 활성화 전(비활성화)
				q.offer(pair);
			} else if (time == pair.start + 1) { // 활성화 
				pq.offer(pair);
			} else if (time > pair.start && time < pair.end) { // 활성화 상태이지만 퍼져나가진 않을 때
				q.offer(pair);
			}
		}
	}
	
	static void ft_bfs(int time) {
		while (!pq.isEmpty()) { // 우선순위 큐로 생명치가 높은 원소부터 꺼냄
			Pair pair = pq.poll();
			
			// **review
			if (pair.end > time) {
				q.offer(pair);
			}
			
			for (int i = 0; i < 4; i++) {
				int nx = pair.x + dx[i];
				int ny = pair.y + dy[i];
				
				if (!visited[nx][ny]) {
					arr[nx][ny] = pair.life;
					// **review
					q.offer(new Pair(nx, ny, pair.life, time + pair.life, time + pair.life * 2));
					visited[nx][ny] = true;
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
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			arr = new int[ARR_SIZE][ARR_SIZE];
			visited = new boolean[ARR_SIZE][ARR_SIZE];
			q = new LinkedList<>();
			pq = new PriorityQueue<>();
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(bf.readLine());
				
				for (int j = 0; j < M; j++) {
					int value = Integer.parseInt(st.nextToken());
					int x = i + CORRECTION_VALUE;
					int y = j + CORRECTION_VALUE;
					
					if (value > 0) {
						arr[x][y] = value;
						q.offer(new Pair(x, y, value, value, value * 2));
						visited[x][y] = true;
					}
				}
			}
			
			for (int i = 1; i <= K; i++) {
				ft_isAlive(i);
				ft_bfs(i);
			}
			
			System.out.println("#" + tc + " " + q.size());
		}
	}
}
