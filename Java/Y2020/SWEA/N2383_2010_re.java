package SWEA;

import java.io.*;
import java.util.*;

public class N2383_2010_re {
	static int N, P, S;
	static int answer;
	
	static void ft_solve(int[] temp, int p, ArrayList<Integer> PR, ArrayList<Integer> PC,
			ArrayList<Integer> SR, ArrayList<Integer> SC, ArrayList<Integer> SL) {
		if (p == P) {
			// **review
			int time = 0;
			
			for (int i = 0; i < S; i++) {
				ArrayList<Integer> list = new ArrayList<>();
				
				for (int j = 0; j < P; j++) {
					if (temp[j] == i) { // 계단 입구까지의 거리
						list.add(Math.abs(PR.get(j) - SR.get(i)) + Math.abs(PC.get(j) - SC.get(i)));
					}
				}
				
				Collections.sort(list);
				
				int stairLen = SL.get(i);
				
				for (int j = 3; j < list.size(); j++) { // 한 계단 한 번에 최대 3명 이용 가능
					if (list.get(j) - list.get(j - 3) < stairLen) {
						list.set(j, stairLen + list.get(j - 3)); 
						// 맨 처음 애 나가야 4번째 애 나갈 수 있음
						// => 계단 입구까지의 거리를 조정함(기다리는 시간으로 인한)
					}
				}
				
				// **review
				time = (list.size() > 0 && list.get(list.size() - 1) + stairLen + 1 > time)? list.get(list.size() - 1) + stairLen + 1 : time;
			}
			
			answer = Math.min(answer, time);
			return;
		}
		
		for (int i = 0; i < S; i++) { // 어떤 계단을 사용할지
			temp[p] = i;
			ft_solve(temp, p + 1, PR, PC, SR, SC, SL);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(bf.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(bf.readLine());
			answer = Integer.MAX_VALUE;
			
			ArrayList<Integer> PR = new ArrayList<>();
			ArrayList<Integer> PC = new ArrayList<>();
			ArrayList<Integer> SR = new ArrayList<>();
			ArrayList<Integer> SC = new ArrayList<>();
			ArrayList<Integer> SL = new ArrayList<>();
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(bf.readLine());
				
				for (int j = 0; j < N; j++) {
					int value = Integer.parseInt(st.nextToken());
					
					switch (value) {
					case 0 :
						break;
					case 1 : // 사람
						PR.add(i);
						PC.add(j);
						break;
						default : // 계단
							SR.add(i);
							SC.add(j);
							SL.add(value);
					}
				}
			}
			
			P = PR.size();
			S = SR.size();
			
			ft_solve(new int[P], 0, PR, PC, SR, SC, SL);
						
			System.out.println("#" + tc + " " + answer);
		}
	}
}
