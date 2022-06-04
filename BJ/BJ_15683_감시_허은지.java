package com.ssafy.boj;

import java.util.*;
import java.io.*;

/*
 * 입력
 * 1. 사무실의 세로 크기 N 가로 크기 M
 * 2. 사무실 각 칸의 정보 0 빈칸 6 벽 1~5 cctv
 * 출력
 * 사각지대의 최소크기
 * 
 * >> 1번: 우 / 2번: 좌우 / 3번: 상우 / 4번: 상좌우 / 5번: 상하좌우
 * >> 방향을 바꾸 수 있음 1: 한쪽 2: 양쪽 3: 직각 4: 한쪽 빼고 5: 모두 다
 * 
 * >> 재귀
 * >> isSelected 사용
 * >> 벽과 cctv가 있는 곳은 사각지대로 치지 않음
 */
public class BJ_15683_감시_허은지 {
	static int N, M, K, cnt, ans;
	static int[][] arr;
	static boolean[][] isSelected;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		isSelected = new boolean[N][M];
		
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]==6) isSelected[i][j]=true; //벽은 가지 못하게 막음
				else if(arr[i][j]!=0) K++;
			}
		} //arr 만들기
		
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				if(arr[i][j] > 0 && arr[i][j] < 6) {
					cctv(i, j, 0);
				}
			}
		}
		
		System.out.println(ans);
	}

	private static void cctv(int x, int y, int cnt) {
		if(cnt == K) {//cctv 체크가 끝나면 사각지대 최소 크기 출력
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<M; j++) {
					if(!isSelected[i][j] && arr[i][j] == 0) {
						cnt++;
					}
				}
			}
			ans = Math.min(ans, cnt);
			return;
		}
		
		if(x<0 || x>=N || y<0 || y>=M) return; //배열 벗어나면 리턴
		
		for(int i = 0; i<4; i++) {//cctv가 4방향으로 돌 수 있음
			
		}
		
		
	}

}
