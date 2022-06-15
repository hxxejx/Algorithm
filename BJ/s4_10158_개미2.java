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
public class s4_10158_개미2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int p = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		
		int T = Integer.parseInt(br.readLine());
		
		int dx = 1;
		int dy = 1;
		int t = 0;
		int min = Integer.MAX_VALUE;
		int dir = 0;
		
		while(true) {
			if(t>=T) break;
			else if(dx==1 && dy==1) {
				dir = 1;
				if(w-p <= h-q) dx *= (-1);
				if(w-p >= h-q) dy *= (-1);
				min = Math.min(w-p, h-q);
				t += min;
				p += min;
				q += min;
			}
			
			else if(dx==-1 && dy==1) {
				dir = 2;
				if(p <= h-q) dx *= (-1);
				if(p >= h-q) dy *= (-1);
				min = Math.min(p, h-q);
				t += min;
				p -= min;
				q += min;
			}
			
			else if(dx==1 && dy==-1) {
				dir = 3;
				if(w-p <= q) dx *= (-1);
				if(w-p >= q) dy *= (-1);
				min = Math.min(w-p, q);
				t += min;
				p += min;
				q -= min;
			}
			
			else if(dx==-1 && dy==-1) {
				dir = 4;
				if(p <= q) dx *= (-1);
				if(p >= q) dy *= (-1);
				min = Math.min(p, q);
				t += min;
				p -= min;
				q -= min;
			}
		}
		
		if(t>T) {
			switch(dir) {
			case 1:
				p -= t-T;
				q -= t-T;
				break;
			case 2:
				p += t-T;
				q -= t-T;
				break;
			case 3:
				p -= t-T;
				q += t-T;
				break;
			case 4:
				p += t-T;
				q += t-T;
				break;
			}
		}
		
		System.out.println(p + " " + q);

	}

}
