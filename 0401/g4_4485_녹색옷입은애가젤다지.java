package com.ssafy.boj;

import java.io.*;
import java.util.*;

/*
 * 입력
 * 1. 동굴의 크기를 나타내는 정수 N
 * 2. 0이 주어지면 입력 종료
 * 3. 도둑루피의 크기(칸을 지나면 k 루피를 잃음)
 * 출력
 * 1. Problem tc: ans
 * 조건
 * 1. 잃는 금액을 최소로 해야 함
 * 
 * >> bfs
 */
public class g4_4485_녹색옷입은애가젤다지 {
	static int N;
	static int[][] arr, rupee;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int tc = 0;
		
		while(true) {
			// 동굴의 크기 N
			N = Integer.parseInt(br.readLine());
			
			// N=0인 입력이 주어지면 전체 입력 종료
			if(N==0) break;
			
			// 도둑루피의 크기와 잃은 루피의 값(방문한 곳)을 담을 배열
			arr = new int[N][N];
			rupee = new int[N][N];
			
			for(int i = 0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j<N; j++) {
					// 도둑루피의 크기 저장
					arr[i][j] = Integer.parseInt(st.nextToken());
					// 가장 작은 값을 구해야 하므로 가장 큰 수로 초기화
					rupee[i][j] = Integer.MAX_VALUE;
				}
			}
			
			// 0, 0부터 시작하기 때문에 값을 넣어 줌
			rupee[0][0] = arr[0][0];
			bfs(0, 0);
			
			// 테스트 케이스: 1, 2, 3...
			tc++;
			
			sb.append("Problem ").append(tc).append(": ").append(rupee[N-1][N-1]).append("\n");
			
		}
		
		System.out.println(sb);
	}
	
	// bfs
	private static void bfs(int i, int j) {
		// 사방탐색을 위한 dx, dy 배열
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		// 배열을 담을 수 있는 큐를 만들어 배열 값(주인공이 이동하는 위치 i, j 좌표)을 추가
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {i, j});
		
		// 큐에 값이 남지 않을 때까지 반복
		while(!queue.isEmpty()) {
			// 큐에서 배열을 꺼낸 뒤 x, y 좌표를 각각 구하기
			int[] q = queue.poll();
			int x = q[0];
			int y = q[1];
			
			// 사방탐색
			for(int k = 0; k<4; k++) {
				int r = x + dx[k];
				int c = y + dy[k];
				
				// 이동한 곳이 배열(동굴)에서 벗어나지 않고,
				// 이동하려는 곳에 저장된 값이 새로 저장하려는 값(이전에 잃은 루피의 값+새로 잃을 루피의 값)보다 작거나 같다면 이동하지 않음
				// rupee[r][c] < rupee[x][y] + arr[r][c]로 계산할 경우, 값은 맞게 나오지만 메모리 초과(가지치기 X)
				if(r<0 || r>=N || c<0 || c>=N || rupee[r][c] <= rupee[x][y] + arr[r][c]) continue;
				
				// 조건에 해당하지 않으면 이전에 잃은 루피의 값+새로 잃을 루피의 값으로 다시 덮어씌움
				rupee[r][c] = rupee[x][y] + arr[r][c];
				
				// 이동한 곳에서 다시 사방탐색 시작
				queue.add(new int[] {r, c});
			}
		}
		
	}

}
