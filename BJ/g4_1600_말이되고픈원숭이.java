package com.ssafy.boj;

import java.io.*;
import java.util.*;

/*
 * 입력
 * 1. 정수 K
 * 2. 격자판의 가로 길이 W, 세로 길이 H
 * 3. 0 아무것도 없는 평지 1 장애물
 * 출력
 * 1. 원숭이의 동작수의 최솟값
 * 2. 갈 수 없으면 -1
 * 
 * >> bfs
 */
public class g4_1600_말이되고픈원숭이 {
	static int K, W, H, ans;
	static int[][] arr;
	static boolean[][][] visited;
	
	static class Monkey {
		int x;
		int y;
		int count;
		int K;
		Monkey(int x, int y, int count, int K){
			this.x = x;
			this.y = y;
			this.count = count;
			this.K = K;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		K = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		arr = new int[H][W];
		visited = new boolean[H][W][K+1];
		
		for(int i = 0; i<H; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<W; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		bfs(0, 0, 0);
		
	}

	private static void bfs(int x, int y, int count) {
		int[] kx = {-2, -2, -1, -1, 1, 1, 2, 2};
		int[] ky = {-1, 1, -2, 2, -2, 2, -1, 1};
		int[] dx = {0, 0, -1, 1};
		int[] dy = {1, -1, 0, 0};
		
		Queue<Monkey> queue = new LinkedList<>();
		queue.add(new Monkey(x,y,count,K));
		visited[x][y][K] = true;

		while(!queue.isEmpty()) {
			Monkey mk = queue.poll();
			if(mk.x== H-1 && mk.y == W-1) {
				ans = mk.count;
				return;
			}
			
			if(mk.K > 0) {
				for(int k = 0; k<8; k++) {
					int i = mk.x+dx[k];
					int j = mk.y+dy[k];
					int cnt = mk.count+1;
					if(i<0 || i>=H || j<0 || j>=W || visited[i][j][mk.K-1] || arr[i][j]==1) continue;
					queue.add(new Monkey(i, j, cnt, mk.K-1));
					visited[i][j][mk.K-1] = true;
				}
			}
			
						
		}
		
	}

}
