package com.ssafy.im;

import java.io.*;
import java.util.*;

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
			
			for(int i = N/2; i>=0; i--) {
				for(int j = N/2-i; j<=N/2+i; j++) {
					sum += farm[i][j];
				}
			}
			
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
