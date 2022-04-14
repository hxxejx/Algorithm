package com.ssafy.bj;

import java.util.*;
import java.io.*;

/*
 * 입력
 * 1. 한 칸에 자라는 참외의 개수 K
 * 2. 한 꼭짓점에서 출발하여 반시계방향으로 방향(동 1 서 2 남 3 북 4)과 길이
 * 출력
 * 1. 밭에서 자라는 참외의 수
 * 조건
 * 1. 참외밭은 ㄱ자 모양
 * 
 * >> 덱에 반복되는 숫자가 나올 때까지 제일 뒤로 돌림
 * >> 방향이 3232, 1414, 4242, 1313처럼 나온다
 */
public class BJ_2477_참외밭_허은지 {
	
	//방향과 길이
	static class Arr {
		int dir;
		int len;
		Arr(int dir, int len){
			this.dir = dir;
			this.len = len;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//한 칸에 자라는 참외의 개수 K
		int K = Integer.parseInt(br.readLine());
		
		//방향과 길이 넣을 덱
		Deque<Arr> deque = new LinkedList<>();
		
		for(int i = 0; i<6; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			int len = Integer.parseInt(st.nextToken());
			deque.add(new Arr(dir, len));
		}
		
		for(int i = 0; i<6; i++) {
			
			//덱에 있는 첫번째 수를 저장
			Arr a = deque.pollFirst();
			//두번째로 있는 수와 제일 뒤에 있는 수가 같으면 
			if(deque.peekFirst().dir == deque.peekLast().dir) {
				//두번째 수 저장
				Arr b = deque.pollFirst();
				//세번째 수가 제일 첫번째 수와 같으면
				if(deque.peekFirst().dir == a.dir) {
					//두번째 수는 앞에 다시 저장하고
					deque.addFirst(b);
					//첫번째 수는 뒤로 보냄
					deque.addLast(a);
					break;
				//세번째 수가 첫번째 수와 다르면
				} else {
					//두번째 수와 첫번째 수 둘 다 앞에 다시 저장
					deque.addFirst(b);
					deque.addFirst(a);
					break;
				}
			}
			//두번째에 있는 수와 제일 뒤에 있는 수가 다르면 첫번째 수를 뒤로 넘기면서 반복
			else deque.addLast(a);
		}
		
		//제일 뒤에 있는 수가 안쪽으로 들어간 변 a
		int a = deque.pollLast().len;
		//첫번째 있는 수가 안쪽으로 들어간 변 b
		int b = deque.poll().len;
		//두번째 있는 수 버리기
		deque.poll();
		//세번째 있는 수가 긴 변 c
		int c = deque.poll().len;
		//네번째 있는 수가 긴 변 d
		int d = deque.poll().len;
		
		//긴 변 두개를 곱해 짧은 변 두개를 곱한 값을 뺀 뒤 참외의 개수 곱해 준다
		System.out.println(((c*d) - (a*b))*K);
		
		
	}

}
