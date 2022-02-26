package com.ssafy.bj;

import java.io.*;
import java.util.*;

/*
 * 입력
 * 1. 입력은 네 줄
 * 2. 직사각형의 위치를 나타내는 네 개의 정수(왼쪽 아래 x, y 오른쪽 위 x,y)
 * 출력
 * 1. 네 개의 직사각형이 차지하는 면적
 * 
 * >> 각각의 위치에 1을 넣은 뒤 마지막에 1의 개수를 세어 출력한다
 */
public class BJ_2669_직사각형네개의합집합의면적구하기_허은지 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//평면
		int[][] arr = new int[101][101];
		
		for(int n = 0; n < 4; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			//왼쪽 아래 x, y 좌표
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			//오른쪽 위 x, y 좌표
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			//왼쪽 아래 x좌표부터 오른쪽 위 x좌표까지
			for(int i = x1; i<x2; i++) {
				//왼쪽 아래 y좌표부터 오른쪽 위 y좌표까지
				for(int j = y1; j<y2; j++) {
					arr[i][j] = 1;
				}
			}
		}
		
		int ans = 0;
		
		//1의 개수 센 뒤 출력
		for (int i = 0; i < 101; i++) {
			for (int j = 0; j < 101; j++) {
				if(arr[i][j]==1) ans++;
			}
		}	
		System.out.println(ans);

	}
}
