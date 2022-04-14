package com.ssafy.bj;

import java.io.*;
import java.util.*;

/*
 * 입력
 * 1. 종이의 가로와 세로 길이 N M
 * 2. 칼로 잘라야 하는 점선의 개수 K
 * 3. 가로는 0과 점선 번호 세로는 1과 점선 번호
 * 출력
 * 1. 가장 큰 사각형의 넓이
 * 
 * >> 가장 긴 선 두 개 구해서 곱하기
 * >> 자르는 위치 받아서 정렬 후 자르기
 * 
 */
public class BJ_2628_종이자르기_허은지 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int K = Integer.parseInt(br.readLine());
		List<Integer> cutN = new ArrayList<>();
		List<Integer> cutM = new ArrayList<>();
		
		cutN.add(0);
		cutM.add(0);
		cutN.add(N);
		cutM.add(M);
		
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			int len = Integer.parseInt(st.nextToken());

			//가로 자르기
			if(dir == 0) cutN.add(len);
			
			//세로 자르기
			else cutM.add(len);
		}
		
		Collections.sort(cutN);
		Collections.sort(cutM);
		
		int maxN = 0;
		int maxM = 0;
		
		for(int i = 1; i < cutN.size(); i++) {
			System.out.println(cutN.get(i)-cutN.get(i-1));
			maxN = Math.max(maxN, cutN.get(i)-cutN.get(i-1));
			
		}
		for(int i = 1; i < cutM.size(); i++) {
			System.out.println(cutM.get(i)-cutM.get(i-1));
			maxM = Math.max(maxM, cutM.get(i)-cutM.get(i-1));
		}
		
		System.out.println(maxN*maxM);

	}

}
