package com.ssafy.boj;

import java.io.*;
import java.util.*;

/*
 * 입력
 * 1. 4줄
 * 2. 8개의 정수
 * 3. 처음 네 개는 첫 번째 직사각형 나중 네 개는 두 번째 직사각형(왼쪽 아래, 오른쪽 위)
 * 출력
 * 1. 직사각형 a 선분 b 점 c 안 겹침 d
 */
public class s1_2527_직사각형 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int[][] s = new int[2][4];
		
		for(int n = 0; n<4; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i<2; i++) {
				for(int j = 0; j <4; j++) {
					s[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			//안 만남
			if(s[0][0] > s[1][2] || s[0][1] > s[1][3] || s[0][2] < s[1][0] || s[0][3] < s[1][1])
				sb.append("d").append("\n");
			//점
			else if((s[0][0] == s[1][2] && s[0][1] == s[1][3]) || (s[0][0] == s[1][2] && s[0][3] == s[1][1]) ||
					(s[0][2] == s[1][0] && s[0][1] == s[1][3]) || (s[0][2] == s[1][0] && s[0][3] == s[1][1]))
				sb.append("c").append("\n");
			//선분
			else if(s[0][0] == s[1][2] || s[0][1] == s[1][3] || s[0][2] == s[1][0] || s[0][3] == s[1][1])
				sb.append("b").append("\n");
			//직사각형
			else sb.append("a").append("\n");
			
		}
		
		System.out.println(sb);

	}

}
