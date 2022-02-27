package com.ssafy.im;

import java.io.*;
import java.util.*;

/*
 * 입력
 * 1. 테스트 케이스 T
 * 2. 배열의 크기 N 파리채의 크기 M
 * 3. N줄에 걸쳐 N*N 배열
 * 출력
 * 1. "#" + tc + " " + ans
 * 
 * >> for문 돌려서 가장 큰 값 저장하기
 */
public class D3_2001_파리퇴치 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int[][] arr = new int[N][N];
			
			for(int i = 0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j<N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
 			}
			
			
			int max = Integer.MIN_VALUE;
			
			for(int i = 0; i<=N-M; i++) {
				for(int j = 0; j<=N-M; j++) {
					int sum = 0;
					for(int k = 0; k<M; k++) {
						for(int l = 0; l<M; l++) {
							sum += arr[i+k][j+l];
						}
						
					}
					max = Math.max(max, sum);
				}
				
			}
			
			sb.append("#").append(tc).append(" ").append(max).append("\n");
			
		}
		
		System.out.println(sb);
		
	}

}
