package com.ssafy.im;

import java.io.*;
import java.util.*;

/*
 * 입력
 * 1. 테스트 케이스 T
 * 2. 농장의 크기 N
 * 3. 농장 내 농작물의 가치
 * 출력
 * 1. 얻을 수 있는 수익
 * 조건
 * 1. 다이아몬드 모양으로 얻을 수 있음
 */
public class D3_2805_농작물수확하기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
		
			int[][] farm = new int[N][N];
			
			for(int i = 0; i<N; i++) {
				String str = br.readLine();
				for(int j = 0; j<N; j++) {
					farm[i][j] = str.charAt(j) - '0';
				}
			}
			
			int sum = 0;
			
			//윗부분
			for(int i = N/2; i>=0; i--) {
				for(int j = N/2-i; j<=N/2+i; j++) {
					sum += farm[i][j];
				}
			}
			
			//아랫부분
			for(int i = N/2-1; i>=0; i--) {
				for(int j = N/2-i; j<=N/2+i; j++) {
					sum += farm[N-i-1][j];
				}
			}
			
			sb.append("#").append(tc).append(" ").append(sum).append("\n");
			
		}
		
		System.out.println(sb);
		
	}

}
