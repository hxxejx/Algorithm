package com.ssafy.boj;

import java.io.*;
import java.util.*;

/*
 * 입력
 * 1. 테스트 케이스 P
 * 2. 테스트 케이스 번호 T와 20개의 양의 정수
 * 3. 아이들의 키
 * 출력
 * 1. 학생들이 뒤로 물러난 걸음 수의 총합
 * 조건
 * 1. 자기보다 큰 학생이 앞에 있다면 제일 앞에 있는 학생 앞으로 선다
 * 2. 그 학생을 포함한 모든 학생이 한 발씩 뒤로 물러선다
 * 
 * >> 덱 사용
 * >> 앞에서부터 큰 사람 만나면 멈춘 뒤 사이즈에서 빼기
 */
public class s5_10413_줄세우기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int P = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc<P; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int T = Integer.parseInt(st.nextToken());
			
			Deque<Integer> student = new LinkedList<>();
			int sum = 0;
			
			//첫 번째 학생 넣음
			student.add(Integer.parseInt(st.nextToken()));
			
			for(int i = 0; i<19; i++) {
				int num = Integer.parseInt(st.nextToken());
				int count = 0;
				
				while(true) {
					if(num<student.peekFirst() || count==student.size()) break;
					student.add(student.pollFirst());
					count++;
				}
				
				student.addFirst(num);
				
				for(int j = 0; j < count; j++) {
					student.addFirst(student.pollLast());
				}
				
				sum += student.size()-1 - count;
				
			}
			
			sb.append(T).append(" ").append(sum).append("\n");
			
		}
		
		System.out.println(sb);
		
		
	}

}
  