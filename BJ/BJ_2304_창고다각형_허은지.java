package com.ssafy.boj;

import java.io.*;
import java.util.*;

/*
 * 입력
 * 1. 기둥의 개수 N
 * 2. 기둥의 x 좌표과 높이 h
 * 출력
 * 1. 다각형의 면적
 * 
 * >> 정렬한 뒤 왼쪽과 오른쪽 나누어 넓이 구하기
 */
public class s2_2304_창고다각형 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] pillar = new int[N][2];
		int tall = 0;
		
		for(int n = 0; n<N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			pillar[n][0] = Integer.parseInt(st.nextToken());
			pillar[n][1] = Integer.parseInt(st.nextToken());
			
			//가장 큰 기둥 높이 구하기
			tall = Math.max(pillar[n][1], tall);
		}
		
		//x좌표 순서로 정렬
		Arrays.sort(pillar, (o1,o2) -> {
			return o1[0]-o2[0];
		});
		 
		//가장 큰 기둥 중 제일 왼쪽에 있는 기둥
		int start = 0;
		for(int i = 0; i<N; i++) {
			if(pillar[i][1]==tall) start = i;
		}
		
		//tall은 따로 더해줘야 하기 때문에 제일 처음에 넣기
		int size = tall;
		
		//제일 첫 기둥
		int prevX = pillar[0][0];
		int prevH = pillar[0][1];
		
		//왼쪽 탐색
		for(int i = 0; i<=start; i++) {
			//이전 기둥보다 큰 기둥이 나타나면 넓이 구하기
			if(pillar[i][1] >= prevH) {
				size += (pillar[i][0]-prevX)*prevH;
				//현재 기둥 정보 갱신
				prevX = pillar[i][0];
				prevH = pillar[i][1];
			}
		}
		
		//마지막 기둥
		prevX = pillar[N-1][0];
		prevH = pillar[N-1][1];
		
		//오른쪽 탐색
		for(int i = N-1; i>=start; i--) {
			//이전 기둥보다 큰 기둥이 나타나면 넓이 구하기
			if(pillar[i][1] >= prevH) {
				size += (prevX - pillar[i][0])*prevH;
				//현재 기둥 정보 갱신
				prevX = pillar[i][0];
				prevH = pillar[i][1];
			}
		}
		
		System.out.println(size);
		

	}

}
