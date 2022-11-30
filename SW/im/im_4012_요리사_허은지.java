package com.ssafy.im;

import java.util.*;
import java.io.*;

/*
 * 입력
 * 1. 테스트 케이스 T
 * 2. 식재료의 수 N
 * 3. 시너지 값 Sij
 * 출력
 * 1. "#" + tc + " " + min
 * 
 * >> 순열
 * >> 같은 재료를 쓸 수 없음 무조건 N/2로 나눠 다른 재료를 써야 함
 * >> 재귀를 이용해 모든 경우의 수를 계산해 보기
 * >> 4개 중에 2개 고르기
 */
public class im_4012_요리사_허은지 {
	static int N, R;
	static boolean[] isSelected;
	static int[][] S;
	static int min;
	

	public static void main(String[] args) throws Exception {
		File file = new File("im_4012_요리사.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			R = N/2;
			
			isSelected = new boolean[N];
			S = new int[N][N];
			int min = Integer.MAX_VALUE;
			
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					S[i][j] = Integer.parseInt(st.nextToken());
				}
			} //시너지 배열
			
			food(0,0);
			System.out.println("#" + tc + " " + min);
		}

	}

	//N개 중 R개 뽑는 조합
	private static void food(int cnt, int start) {
		
		if(start==R) {
			int A = 0;
			int B = 0;
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<N; j++) {
				if(isSelected[i] && isSelected[j]) A += S[i][j];
				else if(!isSelected[i] && !isSelected[j]) B += S[i][j];
				}
			}
			
			min = Math.min(min, Math.abs(A-B));
			return;
		}
		if(cnt==N) return;
		isSelected[cnt] = true;
		food(cnt+1, start+1);
		isSelected[cnt] = false;
		food(cnt+1, start);
		
	}

}
