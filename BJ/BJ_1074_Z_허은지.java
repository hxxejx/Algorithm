package com.ssafy.boj;

import java.util.*;
import java.io.*;

/*
 * 입력
 * N 배열의 크기 2^N r행 c열
 * 출력
 * r행 c열 값이 몇 번째인지 찾기
 * 
 * >> 재귀
 */
public class BJ_1074_Z_허은지 {

	static int N, r, c;
	static int size;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		size = (int) Math.pow(2, N); //2의 N승만큼 배열
		
		System.out.println(Z(0, 0, size)); //가로의 길이, 세로의 길이, 배열 사이즈
		
		
		
	}

	private static int Z(int x, int y, int size) {
		
		if(size == 1) { //size가 1일 때 더 쪼갤 수 있는 칸이 없기 때문에 return
			return 0;
		}
		
		if(r < x + size/2 && c < y + size/2) //1사분면
			return Z(x, y, size/2); //다시 쪼갬
		else if(r < x + size/2 && c < y + size) //2사분면
			return Z(x, y + size/2, size/2) + (int) Math.pow(size/2, 2); //다시 쪼갬
		else if(r < x + size && c < y + size/2) //3사분면
			return Z(x + size/2, y, size/2) + (int) Math.pow(size/2, 2) * 2; //다시 쪼갬
		else //4사분면
			return Z(x + size/2, y + size/2, size/2) + (int) Math.pow(size/2, 2) * 3; //다시 쪼갬
		
	}

}
