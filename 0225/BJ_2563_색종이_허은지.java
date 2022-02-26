package com.ssafy.bj;

import java.io.*;
import java.util.*;

/*
 * 입력
 * 1. 색종이의 수 N
 * 2. 색종이의 위치(왼쪽 아래 x, y 좌표)
 * 출력
 * 1. 색종이가 붙은 검은 영역
 * 조건
 * 1. 색종이의 길이는 10
 * 2. 도화지의 길이는 100
 * 
 * >> 배열에 1을 넣어서 마지막에 출력
 */
public class BJ_2563_색종이_허은지 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//도화지
		int[][] paper = new int[101][101];
		
		//색종이의 수
		int N = Integer.parseInt(br.readLine());
		
		for (int n = 0; n < N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
		
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			//x와 y 좌표로부터 10만큼씩 1로 채움(색종이를 붙임)
			for(int i = x; i < x+10; i++) {
				for(int j = y; j < y+10; j++) {
					paper[i][j] = 1;
				}
			}
			
		}
		
		int ans = 0;
		
		//도화지를 모두 살펴 색종이가 붙은(배열의 값이 1인) 범위를 구함
		for (int i = 0; i < 101; i++) {
			for (int j = 0; j < 101; j++) {
				if(paper[i][j]==1) ans++;
			}
			
		}
		
		System.out.println(ans);

	}

}
