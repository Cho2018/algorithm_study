package SWEA;

import java.io.*;
import java.util.*;

public class N2382_2010_re {
	static int N, M, K;
	static Pair[] pairs;
	static HashMap<Integer, ArrayList<Pair>> map;
	// �� : 1 / �� : 2 / �� : 3 / �� : 4
	static int[] dx = {-1, 0, 1, 0}; // �� �� �� ��
	static int[] dy = {0, 1, 0, -1};
	static int answer;
	
	static class Pair {
		int id, x, y, count, dir;
		
		public Pair(int id, int x, int y, int count, int dir) {
			this.id = id;
			this.x = x;
			this.y = y;
			this.count = count;
			this.dir = dir;
		}
		
		public void setPos(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public void half() {
			this.count = count / 2;
		}
		
		public void reverse() {
			this.dir = (dir + 2) % 4;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(bf.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(bf.readLine());
			N = Integer.parseInt(st.nextToken()); // ���簢�� ũ��
			M = Integer.parseInt(st.nextToken()); // �ð�
			K = Integer.parseInt(st.nextToken()); // ���� ��
			
			pairs = new Pair[K + 1]; // ���� �迭
			map = new HashMap<>();
			answer = 0;
			
			for (int i = 1; i <= K; i++) {
				st = new StringTokenizer(bf.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int count = Integer.parseInt(st.nextToken()); // �ش� ������ �̻��� ��
				int dir = Integer.parseInt(st.nextToken()); // �ش� ������ �̵� ����
				
				if (dir == 1) dir = 0;
				else if (dir == 4) dir = 1;
				
				pairs[i] = new Pair(i, x, y, count, dir);
			}
			
			// **review
			for (int i = 0; i < M; i++) { // �ð� �ҿ�
				int[][] arr = new int[N][N];
				
				for (int j = 1; j <= K; j++) {
					if (pairs[j] == null) {
						continue;
					}
					
					Pair current = pairs[j];
					int nx = current.x + dx[current.dir];
					int ny = current.y + dy[current.dir];
					
					if (nx >= 1 && nx <= N - 2 && ny >= 1 && ny <= N - 2) { // ��ǰ�� ���� ����
						int nextId = arr[nx][ny];
					
						if (nextId == 0) { // �̵��Ϸ��� ��ġ�� �ٸ� ���� ����
							current.setPos(nx, ny);
							arr[nx][ny] = j;
						} else { // �̵��Ϸ��� ��ġ�� �ٸ� ���� ����
							Pair other = pairs[nextId];
							int key = nx * N + ny;
							
							if (map.containsKey(key)) {
								ArrayList<Pair> list = map.get(key);
								current.setPos(nx, ny);
								list.add(current);
							} else {
								ArrayList<Pair> list = new ArrayList<>();
								current.setPos(nx, ny);
								list.add(other);
								list.add(current);
								map.put(key, list);
							}
						}
					} else { // ��ǰ�� ����
						if (current.count == 1) {
							pairs[j] = null;
						} else {
							current.half();
							current.reverse();
							current.setPos(nx, ny);
							arr[nx][ny] = j;
						}
					}
				}
				
				// �� ���� ���� ���� ���� �� ��ġ�� 
				for (ArrayList<Pair> list : map.values()) {
					int sum = 0;
					int max = 0;
					int maxId = 0;
					
					for (Pair pair : list) {
						sum += pair.count;
						
						if (pair.count > max) {
							max = pair.count;
							maxId = pair.id;
						}
					}
					
					pairs[maxId].count = sum;
					
					for (Pair pair : list) {
						if (pair.id == maxId) {
							continue;
						}
						
						pairs[pair.id] = null;
					}
				}
				
				map.clear();
			}
			
			// �̻��� �� ����
			for (int i = 1; i <= K; i++) {
				if (pairs[i] == null) {
					continue;
				} else {
					answer += pairs[i].count;
				}
			}
			
			System.out.println("#" + tc + " " + answer);
		}
	}
}
