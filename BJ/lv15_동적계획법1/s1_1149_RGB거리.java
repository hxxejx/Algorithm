package lv15_동적계획법1;

import java.io.*;
import java.util.*;

/*
 * 입력
 * 1. 집의 수 N
 * 2. 빨강, 초록, 파랑으로 칠하는 비용 >> 배열 세 개
 * 출력
 * 1. 모든 집을 칠하는 비용의 최솟값
 * 조건
 * 1. 1번 집의 색은 2번 집의 색과 같지 않아야 한다
 * 2. N번 집의 색은 N-1번 집의 색과 같지 않아야 한다
 */
public class s1_1149_RGB거리 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] rgb = new int[N][3];

		for(int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			rgb[i][0] = Integer.parseInt(st.nextToken());
			rgb[i][1] = Integer.parseInt(st.nextToken());
			rgb[i][2] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i<N; i++) {
			rgb[i][0] += Math.min(rgb[i-1][1], rgb[i-1][2]);
			rgb[i][1] += Math.min(rgb[i-1][0], rgb[i-1][2]);
			rgb[i][2] += Math.min(rgb[i-1][0], rgb[i-1][1]);
		}
		
		int ans = Math.min(Math.min(rgb[N-1][0], rgb[N-1][1]), rgb[N-1][2]);
		
		System.out.println(ans);
	}

}
