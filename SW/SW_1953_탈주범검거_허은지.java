package com.ssafy.sw;

import java.io.*;
import java.util.*;

/*
 * 입력
 * 1. 테스트 케이스 T
 * 2. 지하 터널 지도 세로 N 가로 M 맨홀 뚜껑 위치 세로 R 가로 C 탈출 후 소요된 시간 L
 * 3. 1~7 터널 구조물 타입 0 터널이 없는 장소
 * 출력
 * 1. #tc ans
 * 조건
 * 1. 1 상하좌우 2 상하 3 좌우 4 상우 5 하우 6 하좌 7 상좌
 * 
 * >> bfs
 */
public class SW_1953_탈주범검거_허은지 {
	static int N, M, L, ans, arr[][];
	static boolean[][] visited;
	
	static class Node {
		int y, x, t;
		
		public Node(int y, int x, int t) {
			this.y = y;
			this.x = x;
			this.t = t;
		}
		
	}
	public static void main(String[] args) throws Exception {
		File file = new File("SW_1953_탈주범검거.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			arr = new int[N][M];
			visited = new boolean[N][M];
			
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			if(L==1) {
				sb.append("#").append(tc).append(" 1\n");
				continue;
			}
			
			for(int i = 0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j<M; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			ans = 0;
			
			bfs(R, C);
			
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
			
		}
		
		System.out.println(sb);
		
	}

	private static void bfs(int r, int c) {
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, -1, 0, 1};
		int[][] dir = {{0, 0, 0, 0}, {1, 1, 1, 1}, {1, 0, 1, 0}, {0, 1, 0, 1}, {1, 0, 0, 1}, {0, 0, 1, 1}, {0, 1, 1, 0}, {1, 1, 0, 0}};
		
		Queue<Node> queue = new ArrayDeque<>();
		
		queue.add(new Node(r, c, 1));
		visited[r][c] = true;
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
	
			ans++;
			
			if(node.t >= L) continue;
			
			int pipe = arr[node.y][node.x];
			
			for(int k = 0; k<4; k++) {
				if(dir[pipe][k] == 0) continue;
				
				int x = node.y + dx[k];
				int y = node.x + dy[k];
				
				if(x<0 || x>=N || y<0 || y>=M || visited[x][y] || arr[x][y] == 0) continue;
				
				if (dir[arr[x][y]][(k + 2) % 4] == 0) {
					continue;
				}
				
				queue.add(new Node(x, y, node.t + 1));
				visited[x][y] = true;
			}

		}
	}
}
