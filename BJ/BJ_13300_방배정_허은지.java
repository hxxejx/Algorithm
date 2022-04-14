package com.ssafy.bj;

import java.io.*;
import java.util.*;

/*
 * 입력
 * 1. 수학여행에 참가하는 학생 수 N 한 방에 배정할 수 있는 최대 인원 수 K
 * 2. 학생의 성별 S(여0 남1) 학년 Y
 * 출력
 * 1. 학생들을 모두 배정하기 위한 최소한의 방의 수
 * 
 * >> 배열로 나눈 뒤 K로 나누어 더한다
 */
public class BJ_13300_방배정_허은지 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] student = new int[2][6];
		
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			
			student[S][Y-1]++;
		}
		
		int room = 0;
		
		for(int i = 0; i<2; i++) {
			for(int j = 0; j<6; j++) {
				if(student[i][j]!=0) {
					room += ((student[i][j]-1)/K)+1;
				}
			}
		}
		
		System.out.println(room);
	}

}
