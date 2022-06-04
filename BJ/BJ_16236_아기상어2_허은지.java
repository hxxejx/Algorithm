package com.ssafy.boj;

import java.util.*;
import java.io.*;

/*
 * 입력
 * 1. 공간의 크기 N
 * 2. 공간의 상태(0 빈칸 123456 칸에 있는 물고기 9 아기 상어의 위치)
 * 출력
 * 아기 상어가 엄마 상어에게 도움을 요청하지 않고 물고기를 잡아먹을 수 있는 시간
 * 조건
 * 1. 가장 처음 아기 상어의 크기는 2(1부터 차례로 먹을 수 있지만 2가 있는 칸을 지나갈 수는 있다)
 * 2. 더 이상 먹을 수 있는 물고기가 없으면 끝
 * 3. 먹을 수 있는 물고기가 1마리보다 많으면, 거리가 가장 가까운 물고기를 먹으러 간다
 * 		=> 지나야 하는 칸의 최솟값
 * 		=> 그러한 물고기가 많으면 좌측 상단부터 먹는다
 * 4. 크기가 2인 상태라면 2마리를 먹어야 3이 된다 3이라면 3마리를 먹어야 4가 된다
 * 5. 한 칸 이동할 때 1초가 걸린다
 * 
 * >> 자기보다 작은 물고기가 자기의 크기만큼 있는지 탐색 없으면 return => 미리 배열에 넣어두기
 * >> 있다면 최소 거리 구하기 두 개 이상이라면 상단 좌측부터 이동 => bfs
 * >> 이동할 때 자신보다 크기가 크면 이동하지 못함 => 사방탐색 + if
 * >> 먹고 나면 0으로 바꾸기
 * >> 자기 크기만큼 먹은 뒤 +1 => 재귀
 * >> 반복
 */
public class BJ_16236_아기상어2_허은지 {
	static int N;
	static int[] fish;
	static int[][] arr;
	static int[][] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		fish = new int[7]; // 물고기의 개수
		arr = new int[N][N]; //공간
		visited = new int[N][N];
		
		int x = 0, y = 0; //아기상어 초기 위치
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				int num = Integer.parseInt(st.nextToken());
				arr[i][j] = num;
				
				fish[i]++;
				
				//아기상어의 초기 위치
				if(num==9) {
					x = i;
					y = j;
					arr[i][j] = 0;
				}
			}
		} // 배열 초기화 for
		
		int size = 2;
		
		//크기가 1인 물고기가 2개보다 적다면 0 출력 후 끝냄
		if(fish[1]<size) {
			System.out.println(0);
			System.exit(0);
		}
		
		eat(x, y, 0, size);
		
	}
	
	// bfs
	private static void eat(int x, int y, int count, int size) {
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		int small = 0;
		int min = Integer.MAX_VALUE;
		int minX = Integer.MAX_VALUE;
		int minY = Integer.MAX_VALUE;
		
		// 아기상어 현재 사이즈만큼의 물고기가 없으면 이동거리 출력 후 종료
		for(int i = 1; i<size; i++) {
			small += fish[i];
		}
		
		if(small<size) {
			System.out.println(count);
			System.exit(0);
		}
		
		//size만큼 물고기 먹으면 size 올라감
		if(count==size) eat(x, y, count, size+1);
		
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {x,y});
		
		while(!queue.isEmpty()) {
			int[] xy = queue.poll();
			x = xy[0];
			y = xy[1];
			
			// 사방탐색
			for(int k = 0; k < 4; k++) {
				int r = x+dx[k];
				int c = y+dy[k];
				
				//배열을 벗어나면 continue
				if(r<0 || r>=N || c<0 || c>=N) continue;
				
				//아기상어의 크기보다 작거나 같고 방문한 적 없으면 탐색
				if(arr[r][c]<=size && visited[r][c]==0) {
					visited[r][c] = visited[x][y] + 1;
					//아기상어의 크기보다 작으면 먹음
					if(arr[r][c]<=size) {
						//가장 가까운 곳을 골라서 먹음
						if(min > visited[r][c]) {
							minX = r;
							minY = c;
							//가장 가까운 곳이 두 곳 이상이면
						} else if(min == visited[r][c]) {
							//X가 같을 때
							if(minX == r) {
								//Y가 더 작은 쪽을 먹음
								if(minY > c) {
									minX = r;
									minY = c;
								}
								//아니면 X가 더 작은 쪽을 먹음
							} else if (minX > r) {
								minX = r;
								minY = c;
							}
						}
					}
					queue.add(new int[] {r,c});
				}
			}
			
			
		}
		
		
		
	}

}
