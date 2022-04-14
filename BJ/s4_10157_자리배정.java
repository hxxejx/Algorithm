package com.ssafy.boj;

import java.io.*;
import java.util.*;

/*
 * 입력
 * 1. 공연장의 크기 C R
 * 2. 관객의 대기번호 K
 * 출력
 * 1. 관객의 좌석 번호 x, y
 * 2. 배정할 수 없으면 0
 * 조건
 * 1. 왼쪽 아래부터 1,1
 * 2. 왼쪽 아래부터 1 달팽이로 들어감
 */
public class s4_10157_자리배정 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int C = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		int[][] seat = new int[C+1][R+1];
		
		int K = Integer.parseInt(br.readLine());

		if(K>C*R) {
			System.out.println(0);
			System.exit(0);
		}
		
		int[] dx = {0, 1, 0, -1};
		int[] dy = {1, 0, -1, 0};
		
		int num = 1;
		int x = 1;
		int y = 0;
		int i = 0;
		
		while(true) {
			x += dx[i];
			y += dy[i];
			if(x<1 || x>C || y<1 || y>R || seat[x][y] != 0) {
				x -= dx[i];
				y -= dy[i];
				i++;
				if(i==4) i=0;
				continue;
			}
			seat[x][y] = num;
			if(K == num) break;
			num++;
		}
		
		System.out.println(x + " " + y);
		
	}

}
