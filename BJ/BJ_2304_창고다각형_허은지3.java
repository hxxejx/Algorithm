package com.ssafy.bj;

import java.io.*;
import java.util.*;

/*
 * 입력
 * 1. 기둥의 개수를 나타내는 정수 N
 * 2. 각 기둥의 왼쪽 면의 x좌표를 나타내는 L 높이를 나타내는 H
 * 출력
 * 1. 창고 다각형의 면적
 * 조건
 * 1. 계속해서 위로 올라가다가 가장 높은 기둥을 만나면 내려와야 함
 * 
 * >> 가장 높은 기둥 구하기
 * >> 가장 높은 기둥과 양 끝 사이 기둥에서 더 작은 기둥은 저장하지 않음
 * >> 양쪽에서 기둥이 높아질 때마다 넓이 구하기
 * >> 가장 높은 기둥 면적 구해서 더하기
 */
public class BJ_2304_창고다각형_허은지3 {
	static class Pillar {
		int x;
		int h;
		Pillar(int x, int h){
			this.x = x;
			this.h = h;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[1001];
		List<Pillar> list = new LinkedList<>();
		boolean right = false;
		
		int tall = Integer.MIN_VALUE;
		
		for(int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken());
			int H = Integer.parseInt(st.nextToken());
			
			arr[L] = H;
			
			tall = Math.max(tall, H);
		}
		
		for(int i = 0; i<1001; i++) {
			if(arr[i]!=0) list.add(new Pillar(i, arr[i]));
		}
		
		int prevX = list.get(0).x;
		int prevH = list.get(0).h;
		
		if(prevH==tall) right = true;
		
		int size = tall;
		
		for(int i = 1; i<list.size(); i++) {
			System.out.println("--------------");
			System.out.println(tall);
			System.out.println(list.get(i).h);
			System.out.println(prevH);
			System.out.println(right);
			System.out.println("----------");
			if(list.get(i).h==tall) {
				System.out.println("제일 높은거");
				size += (list.get(i).x - prevX) * prevH;
				right = true;
				prevX = list.get(i).x;
				prevH = list.get(i).h;
			}
			
			else if(!right && list.get(i).h>prevH) {
				System.out.println("높은 기둥 발견");
				size += (list.get(i).x - prevX) * prevH;
				prevX = list.get(i).x;
				prevH = list.get(i).h;
			}
			
			
			else if(right && list.get(i).h<=prevH && list.get(i).h >= list.get(list.size()-1).h) {
				System.out.println("낮은 기둥 발견");
				size += (list.get(i).x - prevX) * list.get(i).h;
				prevX = list.get(i).x;
				prevH = list.get(i).h;
			}
			System.out.println(size);
		}
		
		System.out.println(size);

	}

}
