package com.ssafy.bj;

import java.io.*;
import java.util.*;

/*
 * 입력
 * 1. 학생의 수 N
 * 2. 학생들이 뽑은 번호
 * 출력
 * 1. 학생들이 최종적으로 줄을 선 순서
 * 조건
 * 1. 0을 뽑으면 그 자리에 있고, 1을 뽑으면 1칸 앞으로 가 선다 2를 뽑으면 2칸 앞으로 가 선다 N-1까지 반복
 * 
 * >> 큐 사용
 * >> 학생들이 뽑는 숫자만큼 큐를 이용해 뒤로 돌리고, 학생을 끼워넣은 뒤에는 나머지도 모두 돌린다
 */
public class BJ_2605_줄세우기_허은지 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		//학생들의 순서 큐
		Queue<Integer> queue = new LinkedList<>();
		
		//학생들의 수
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i<=N; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			//현재 줄을 서 있는 학생들의 수에서 뽑은 숫자를 뺀 만큼 뒤로 보낸다
			for(int j = 0; j<queue.size()-num; j++) {
				queue.add(queue.poll());
			}
			
			//제일 뒤에 줄을 세운다
			queue.add(i);
			
			//뽑은 숫자만큼 학생을 뒤로 보낸다
			for(int j = 0; j<num; j++) {
				queue.add(queue.poll());
			}
		}
		
		for(int i = 0; i<N; i++) {
			sb.append(queue.poll()).append(" ");
		}
		
		System.out.println(sb);

	}

}
