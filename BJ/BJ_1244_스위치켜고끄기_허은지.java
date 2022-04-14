package com.ssafy.bj;

import java.io.*;
import java.util.*;

/*
 * 입력
 * 1. 스위치 개수 N
 * 2. 스위치의 상태(켜짐 1 꺼짐 0)
 * 3. 학생 수 M
 * 4. 학생의 성별(남자 1 여자 2) 학생이 받은 스위치의 번호
 * 출력
 * 1. 스위치의 상태(켜짐 1 꺼짐 0)
 * 2. 한 줄에 20개씩만 출력
 * 조건
 * 1. 남학생: 스위치 번호가 자기가 받은 수의 배수이면 그 스위치의 상태를 바꾼다
 * 2. 여학생: 자신이 받은 스위치를 중심으로 좌우가 대칭이면 계속 바꾼다 대칭이 아니면 멈춘다
 * 
 * >> 마지막에 if와 나머지 써서 20개씩만 출력하기
 * >> 배열
 */
public class BJ_1244_스위치켜고끄기_허은지 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		//스위치 개수 N
		int N = Integer.parseInt(br.readLine());
		
		boolean[] sw = new boolean[N];
		
		//리스트에 현재 스위치 상태 추가
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(num==1) sw[i] = true;
			else sw[i] = false;
		}
		
		//학생 수 M
		int M = Integer.parseInt(br.readLine());
		
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int swNum = Integer.parseInt(st.nextToken());
			
			//남학생일 때
			if(s==1) {
				for(int j = 0; j<N; j++) {
					//해당 스위치 번호를 남학생의 스위치 번호로 나눴을 때 나머지가 0이면 상태를 바꾼다
					if((j+1)%swNum==0) sw[j] = !sw[j];
				}
			}
			
			//여학생일 때
			else if(s==2) {
				swNum--;
				//자신이 받은 스위치 상태 변경
				sw[swNum] = !sw[swNum];
				
				//끝에 있을 때는 대칭되는 양쪽 스위치가 존재하지 않기 때문에 continue
				//if(swNum == 0 || swNum == N-1) continue;
				
				//for문을 이용한 계산
				for(int j = 1; j<N; j++) {
					if(swNum-j < 0 || swNum+j >= N || sw[swNum-j] != sw[swNum+j]) break;
					sw[swNum+j] = !sw[swNum+j];
					sw[swNum-j] = !sw[swNum-j];
				}

				//while문을 이용한 계산
//				int tmp = 1;
//				while(true) {
//					if(swNum-tmp < 0 || swNum+tmp >= N) break;
//					
//					if(sw[swNum+tmp] == sw[swNum-tmp]) {
//						sw[swNum+tmp] = !sw[swNum+tmp];
//						sw[swNum-tmp] = !sw[swNum-tmp];
//			
//						tmp++;
//					} else break;
//				}
			}
		}
		
		//출력
		//20개 이상이면 나눠서 몫만큼 for문으로 출력
		//나머지만큼 출력
		
		//20 이상일 때
		if(N>20) {
			for(int i = 0; i<N/20; i++) {
				for(int j = 0; j < 20; j++) {
					if(sw[j+(20*i)]) sb.append(1).append(" ");
					else sb.append(0).append(" ");
				}
				sb.append("\n");
			}
		}
		//나머지 출력
		for(int i = 0; i<N%20; i++) {
			if(sw[i+(N/20)*20]) sb.append(1).append(" ");
			else sb.append(0).append(" ");
		}
		
		//왜 틀렸지??
//		for(int i = 0; i<(N-1)/20; i++) {
//			for(int j = i*20; j < 20+i*20; j++) {
//				if(sw[j]) sb.append(1).append(" ");
//				else sb.append(0).append(" ");
//			}
//			sb.append("\n");
//		}
//		
//		for(int i = 0; i<N%20; i++) {
//			if(sw[N/20*20+i]) sb.append(1).append(" ");
//			else sb.append(0).append(" ");
//		}
		
		System.out.println(sb);

	}

}
