package com.ssafy.bj;

import java.io.*;
import java.util.*;

/*
 * 입력
 * 1. 색종이의 수 N
 * 2. 색종이의 위치(왼쪽 아래 x, y 좌표) 색종이의 너비 w 색종이의 높이 h
 * 출력
 * 1. 입력된 순서대로 색종이가 보이는 부분의 면적 보이지 않으면 0
 * 조건
 * 2. 도화지의 길이는 1001
 * 
 * >> 배열에 1, 2, 3... 을 넣어서 마지막에 출력
 */
public class BJ_10163_색종이_허은지 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		//도화지
		int[][] paper = new int[1001][1001];
		
		//색종이의 수
		int N = Integer.parseInt(br.readLine());
		
		for (int n = 1; n <= N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
		
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			
			//x와 y 좌표로부터 너비 w, 높이 h만큼씩 n으로 채움(색종이를 붙임)
			for(int i = x; i < x+w; i++) {
				for(int j = y; j < y+h; j++) {
					paper[i][j] = n;
				}
			}
			
		}
		
		//색종이 크기 구할 배열
		int[] num = new int[N];
		
		//도화지를 모두 살펴 각각의 색종이가 붙은(배열의 값이 n인) 범위를 구함
		for (int i = 0; i < 1001; i++) {
			for (int j = 0; j < 1001; j++) {
				if(paper[i][j]!=0) num[paper[i][j]-1]++;
			}	
		}
		
		for(int i = 0; i<N; i++) {
			sb.append(num[i]).append("\n");
		}

		System.out.println(sb);

	}

}
