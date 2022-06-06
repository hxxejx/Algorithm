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
public class BJ_2304_창고다각형_허은지 {
	static class Pillar {
		int x;
		int h;
		Pillar(int x, int h){
			this.x = x;
			this.h = h;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[2][N];
		List<Integer> list = new ArrayList<>();
		boolean right = false;
		
		int tall = Integer.MIN_VALUE;
		
		for(int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken());
			int H = Integer.parseInt(st.nextToken());

			arr[0][i] = L;
			arr[1][i] = H;
			
			//list.add(new Pillar(L,H));
			
			tall = Math.max(tall, H);
		}
		
		//x 순서대로 정렬하기
		
		
		//deque.add(new Pillar(arr[0][0], arr[1][0]));
		
		int prevX = arr[0][0];
		int prevH = arr[1][0];
		
		int size = tall;
		
		System.out.println(prevX);
		System.out.println(prevH);
		
		for(int i = 1; i<N; i++) {
			if(!right && arr[1][i]>prevH) {
				size += (arr[0][i] - prevX) * prevH;
				prevX = arr[0][i];
				prevH = arr[0][i];
			}
			if(arr[1][i]==tall) {
				right = true;
				prevX = arr[0][i];
				prevH = arr[0][i];
			}
			if(right && arr[1][i]<prevH) {
				size += (arr[0][i] - prevX) * arr[1][i];
				prevX = arr[0][i];
				prevH = arr[0][i];
			}
			System.out.println(size);
//			if(!right && arr[1][i]>deque.peekLast().h) deque.add(new Pillar(arr[0][i], arr[1][i]));
//			if(arr[1][i]==tall) right = true;
//			if(right && arr[1][i]<deque.peekLast().h) deque.add(new Pillar(arr[0][i], arr[1][i]));

		}
		
		System.out.println(size);

	}

}
