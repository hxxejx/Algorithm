package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/*
 * 1. 탑의 수 N
 * 2. 띄어쓰기 탑의 높이 N개
 * 
 * >> stack
 * >> 왼쪽부터 차례로 하나씩 넣고
 * >> peek와 넣을 값을 비교해서 peek가 더 낮으면 pop
 * >> count 더해서 값 구함 >> 이걸로는 중간에 건너뛰는 숫자 계산이 안 됨
 * >> 넣을 때부터 배열로 숫자와 위치를 함께 넣기
 */
public class G5_2493_탑 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Stack<int[]> stack = new Stack<>(); //배열을 담은 스택
		
		for(int tc = 1; tc <= N; tc++) {
			int num = Integer.parseInt(st.nextToken());
			
			while(!stack.isEmpty()) { //비어 있지 않고
				if(stack.peek()[1] < num) { //peek가 num보다 작으면
					stack.pop(); // pop
				} else { //peek가 num보다 크면
					System.out.print(stack.peek()[0] + " "); //count 값 프린트
					break;
				}
				
			}

			if(stack.isEmpty()) {
				System.out.print("0 ");
			}
			stack.push(new int[] {tc, num}); //count 값과 num 입력
		}
	}

}
