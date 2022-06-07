package com.ssafy.bj;

import java.io.*;
import java.util.*;

/*
 * 입력
 * 1. 기둥의 개수를 나타내는 정수 N
 * 2. 각 기둥의 왼쪽 면의 x좌표를 나타내는 L 높이를 나타내는 H
 * 출력
 * 1. 창고 다각형의 면적
 * 조건
 * 1. 계속해서 위로 올라가다가 가장 높은 기둥을 만나면 내려와야 함
 * 
 * >> 가장 높은 기둥 구하기
 * >> 가장 높은 기둥과 양 끝 사이 기둥에서 더 작은 기둥은 저장하지 않음
 * >> 양쪽에서 기둥이 높아질 때마다 넓이 구하기
 * >> 가장 높은 기둥 면적 구해서 더하기
 */
public class BJ_2304_창고다각형_허은지2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[2][N];
		int[][] arr2 = new int[2][N];
		List<Integer> x = new ArrayList<>();
		boolean right = false;
		
		int tall = Integer.MIN_VALUE;
		
		for(int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken());
			int H = Integer.parseInt(st.nextToken());

			arr2[0][i] = L;
			arr2[1][i] = H;
			x.add(L);
			
			tall = Math.max(tall, H);
		}
		
		//x 순서대로 정렬하기
		Collections.sort(x);
		
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				if(x.get(i) == arr2[0][j]) {
					arr[0][i] = arr2[0][j];
					arr[1][i] = arr2[1][j];
				}
			}
		}
		
		int prevX = arr[0][0];
		int prevH = arr[1][0];
		
		int size = tall;
		
		for(int i = 1; i<N; i++) {
			if(!right && arr[1][i]>prevH && arr[1][i] != tall) {
				size += (arr[0][i] - prevX) * prevH;
				prevX = arr[0][i];
				prevH = arr[1][i];
			}
			if(arr[1][i]==tall) {
				size += (arr[0][i] - prevX) * prevH;
				right = true;
				prevX = arr[0][i];
				prevH = arr[1][i];
			}

			if(right && arr[1][i]<prevH && arr[1][i] >= arr[1][N-1]) {
				
				size += (arr[0][i] - prevX) * arr[1][i];
				prevX = arr[0][i];
				prevH = arr[1][i];
			}

		}
		
		System.out.println(size);

	}

}
