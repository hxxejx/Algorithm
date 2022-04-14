package com.ssafy.bj;

import java.util.*;
import java.io.*;

/*
 * 입력
 * 1. 아홉 줄에 걸쳐 난쟁이의 키 주어짐
 * 출력
 * 1. 일곱 난쟁이의 키를 오름차순으로 출력
 * 조건
 * 1. 일곱 난쟁이의 키의 합은 100
 * 
 * >> 랜덤으로 두 난쟁이의 키의 합을 구한 뒤 아홉 난쟁이의 키의 합에서 빼고 100이면 출력
 */
public class BJ_2309_일곱난쟁이_허은지 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		//난쟁이의 키
		int[] height = new int[9];
		
		//난쟁이의 키의 합
		int sum = 0;
		
		for(int i = 0; i<9; i++) {
			int h = Integer.parseInt(br.readLine());
			height[i] = h;
			sum += h;
		}

		outer: for(int i = 0; i<8; i++) {
			for(int j = i+1; j<9; j++) {
				//전체 난쟁이의 크기에서 두 난쟁이의 키를 뺌
				sum -= height[i] + height[j];
				if(sum==100) {
					//가짜 난쟁이들의 키를 0으로 바꿈
					height[i] = 0;
					height[j] = 0;
					break outer;
				}
				//가짜 난쟁이가 아니라면 다시 더해 줌
				else sum += height[i] + height[j];
			}
		}
		
		//오름차순으로 정렬
		Arrays.sort(height);
		
		//가짜 난쟁이 둘은 키가 0이므로 3번째 난쟁이부터 출력
		for(int i = 2; i<9; i++) {
			sb.append(height[i]).append("\n");
		}
		
		System.out.println(sb);
		
	}

}
