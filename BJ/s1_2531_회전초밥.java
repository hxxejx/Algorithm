package com.ssafy.boj;

import java.io.*;
import java.util.*;

/*
 * 입력
 * 1. 접시의 수 N, 초밥의 가짓수 d, 연속해서 먹는 접시의 수 k, 쿠폰 번호 c
 * 2. 회전 방향을 따라갈 때 초밥의 종류를 나타내는 정수
 * 출력
 * 1. 초밥의 가짓수의 최댓값
 * 조건
 * 1. 한 위치부터 k의 접시를 연속해서 먹을 경우 할인된 정액 가격으로 제공
 * 2. 쿠폰 c에 적힌 초밥은 무료로 제공, k개를 먹을 동안 없으면 만들어서 줌
 * 3. 가능한 한 다양한 종류의 초밥을 먹으려고 함
 * 4. 쿠폰 c에 적힌 초밥은 k에 포함되지 않음
 * 
 * >> 투 포인터
 * >> start와 end를 이용해 풀이
 */
public class s1_2531_회전초밥 {
	static int N, d, k, c, max;
	static int[] table, sushi;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		table = new int[N];
		sushi = new int[d+1];
		
		for (int i = 0; i < N; i++) {
			table[i] = Integer.parseInt(br.readLine());
		}
		
		check(0);
		
		System.out.println(max);

	}

	private static void check(int cnt) {
		for (int i = 0; i < k; i++) {			
			if(sushi[table[i]]==0) cnt++;
			sushi[table[i]]++;
		}
		
		max = cnt;	

		for(int start = 0; start<N-1; start++) {
			if(cnt >= max) {
				if(sushi[c]==0) max = cnt+1;
				else max = cnt;
			}
			
			int end = (start+k)%N;

			sushi[table[start]]--;
			if(sushi[table[start]]==0) cnt--;
			if(sushi[table[end]]==0) cnt++;
			sushi[table[end]]++;
			
		}

	}
}