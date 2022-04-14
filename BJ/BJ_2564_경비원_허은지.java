package com.ssafy.bj;

import java.io.*;
import java.util.*;

/*
 * 입력
 * 1. 블록의 가로의 길이 N와 세로의 길이 M
 * 2. 상점의 개수 K
 * 3. 상점의 방향과 좌표(북1 남2 서3 동4, 왼쪽 위부터)
 * 4. 동근이의 위치
 * 출력
 * 1. 동근이의 위치와 각 상점 사이의 최단 거리의 합
 * 
 * >> 총 길이는 2*(N+M)
 * >> 0,0부터 일자로 쭉 스택에 쌓기
 */
public class BJ_2564_경비원_허은지 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int K = Integer.parseInt(br.readLine());
		
		Stack<Integer> stack = new Stack<>();
		
		for(int i = 0; i < K+1; i++) {
			st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			
			switch(dir) {
			//북쪽
			case 1:
				stack.push(num);
				break;
			//남쪽
			case 2:
				stack.push(N+M+N-num);
				break;
			//서쪽
			case 3:
				stack.push(N+M+N+M-num);
				break;
			//동쪽
			case 4:
				stack.push(N+num);
				break;
			}
		}
		
		//동근이의 위치
		int x = stack.pop();
		int sum = 0;
		
		for(int i = 0; i<K; i++) {
			int num = stack.pop();
			//동근이와 호출 위치의 차이
			int len = Math.abs(num-x);
			//시계방향과 반시계 방향 중 적은 것으로 더하기
			sum += Math.min((N+M)*2-len, len);
		}
		
		System.out.println(sum);

	}

}
