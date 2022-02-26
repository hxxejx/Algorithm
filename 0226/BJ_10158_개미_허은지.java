package com.ssafy.boj;

import java.io.*;
import java.util.*;

/*
 * 입력
 * 1. 가로 w 세로 h
 * 2. 초기 위치의 좌표 p q
 * 3. 개미가 움직일 시간 t
 * 출력
 * 1. t시간 후 개미의 위치 좌표 x y
 * 조건
 * 1. 한 시간마다 p+1, q+1로 움직임
 * 2. 경계면에 부딪치면 같은 속력으로 반사
 */
public class s4_10158_개미 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int p = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		
		int T = Integer.parseInt(br.readLine());
		
		int T1 = T-(w-p);
		int T2 = T-(h-q);
		
		if(T1>=0) {
			if((T1/w)%2 == 0) p = w-(T1%w);
			else p = T1%w;
		} else p = p+T;
		
		if(T2>=0) {
			if((T2/h)%2 == 0) q = h-(T2%h);
			else q = T2%h;
		} else q = q+T;

		System.out.println(p + " " + q);

	}

}
