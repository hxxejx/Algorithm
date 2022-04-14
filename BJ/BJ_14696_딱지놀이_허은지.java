package com.ssafy.bj;

import java.io.*;
import java.util.*;

/*
 * 입력
 * 1. 총 라운드 수 N
 * 2. 어린이 A가 내는 딱지
 * 3. 어린이 B가 내는 딱지
 * 출력
 * 1. 승자의 알파벳
 * 2. 무승부일 때는 D
 * 
 * >> if else
 */
public class BJ_14696_딱지놀이_허은지 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());

		outer: for(int i = 0; i<N; i++) {
			//별, 동그라미, 네모, 세모 순서
			int[] shapeA = new int[4];
			int[] shapeB = new int[4];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			for(int j = 0; j<num; j++) {
				int shape = Integer.parseInt(st.nextToken());
				shapeA[shape-1]++;
			}
			st = new StringTokenizer(br.readLine());
			num = Integer.parseInt(st.nextToken());
			for(int j = 0; j<num; j++) {
				int shape = Integer.parseInt(st.nextToken());
				shapeB[shape-1]++;
			}
			
			for(int j = 3; j>=0; j--) {
				if(shapeA[j]>shapeB[j]) {
					sb.append("A\n"); continue outer;
				}
				else if(shapeA[j]<shapeB[j]) {
					sb.append("B\n"); continue outer;
				}
			}
			
			sb.append("D\n");

		}
		
		System.out.println(sb);
	}

}
