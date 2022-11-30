package com.ssafy.im;

import java.io.*;
import java.util.*;

/*
 * 입력
 * 1. 10개의 테스트 케이스
 * 2. 덤프 횟수 N
 * 3. 각 상자의 높이값
 * 출력
 * 1. #tc 최고점과 최저점의 높이 차
 * 조건
 * 1. 상자의 개수는 항상 100
 * 
 * >> 배열에 넣은 뒤 정렬하고 덤프를 끝내면 재정렬
 */
public class D2_1208_Flatten {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int tc = 1; tc<=10; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] box = new int[100];
		
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i<100; i++) {
				box[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(box);
			
			for(int i = 0; i<N; i++) {
				box[99]--;
				box[0]++;
				Arrays.sort(box);
			}
			
			sb.append("#").append(tc).append(" ").append(box[99]-box[0]).append("\n");
			
		}
		
		System.out.println(sb);
		
	}

}
