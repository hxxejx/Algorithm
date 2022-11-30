package com.ssafy.sw;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW_1953_탈주범검거_허은지2 {
	public static class Info {
		int y, x, time;

		public Info(int y, int x, int time) {
			super();
			this.y = y;
			this.x = x;
			this.time = time;
		}
	}
	
	public static int N, M, R, C, L, answer;
	public static boolean[][] visited;
	public static int[][] map;
	public static void main(String[] args) throws IOException {
		File file = new File("SW_1953_탈주범검거.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder("");
		StringTokenizer st = null;		
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; ++tc) {
			st = new StringTokenizer(br.readLine(), " ");
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			visited = new boolean[N][M];
			map = new int[N][M];
			
			for (int i = 0; i < N; ++i) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < M; ++j) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			answer = 0;
			bfs();
			
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		
		System.out.println(sb);
	}
	
		// 인덱스 -> 0 : 상, 1 : 좌, 2 : 하, 3 : 우
	public static int[] dy = {-1, 0, 1, 0};
	public static int[] dx = {0, -1, 0, 1};
	public static int[][] dir = {{0, 0, 0, 0}, {1, 1, 1, 1}, {1, 0, 1, 0}, {0, 1, 0, 1}, {1, 0, 0, 1}, {0, 0, 1, 1}, {0, 1, 1, 0}, {1, 1, 0, 0}};
	
	public static void bfs() {
		Queue<Info> q = new LinkedList<Info>();
		q.offer(new Info(R, C, 1));
		visited[R][C] = true;
		
		while (!q.isEmpty()) {
			Info info = q.poll();
			
			// 이동했으므로 정답 +1
			answer++;
			
			// L이후는 조사할 필요가 없다.
			if (info.time >= L) {
				continue;
			}
			
			// 현재 파이프의 타입
			int type = map[info.y][info.x];
			
			for (int i = 0; i < 4; ++i) {
				if (dir[type][i] == 0) {
					continue;
				}
				
				int ny = info.y + dy[i];
				int nx = info.x + dx[i];
				
				
				if (nx < 0 || ny < 0 || nx >= M || ny >= N) {
					continue;
				}
				
				if (!visited[ny][nx] && map[ny][nx] != 0) {
                	// map[y][x]가 왼쪽으로 나간다면
                	// map[ny][nx]는 오른쪽으로 들어와야한다.
                	// i는 현재 방향임
                	// 때문에 0이되면 전진이 불가능하므로 갈 수 없다.
					if (dir[map[ny][nx]][(i + 2) % 4] == 0) {
						continue;
					}
					
					q.offer(new Info(ny, nx, info.time + 1));
					visited[ny][nx] = true;
				}
			}
		}
	}
}