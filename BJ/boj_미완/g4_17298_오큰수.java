package boj_미완;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class g4_17298_오큰수 {

	/*
	 * 1. 첫째 줄 N 수열의 크기
	 * 2. 수열의 원소 띄어쓰기로 구분
	 * 3. stack에 넣기
	 * 		>> 1 3 5 7 순서로 넣으면 스택에서 꺼낼 때는 7 5 3 1 순서로 꺼냄
	 * 4. NGE(1) 구해서 저장한 뒤 하나씩 출력
	 * 		>> 다른 스택에 복사
	 * 		>> 하나씩 꺼내며 큰 수가 나오면 바로 출력
	 * 		>> 없으면 -1
	 * 5. 마지막은 무조건 -1
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> A = new Stack<>();
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			A.push(num);
		} // stack 쌓기
		
		Stack<Integer> result = new Stack<>();
		Stack<Integer> stack = new Stack<>();
		
		Outer: for(int i = 0; i < N; i++) {
			System.out.println(A + " 초기 A값");
			int pop = 0;
			
			int NGE = A.pop();
			
			if(A.size() == N -1) { //제일 마지막 수는
				System.out.println("7은 -1");
				result.push(-1); //무조건 -1
				continue Outer;
			}
			
			System.out.println(A.size());
			for(int j = 0; j < A.size(); j++) {
				stack = A;
				if(NGE > stack.peek()) {
					stack.pop();
					System.out.println(stack +" 스택값 출력");
				} else if(NGE < stack.peek()) {
						pop = stack.pop();
						result.push(pop);
						break;
				}
			}
			if(pop==0) result.push(-1);
			
			System.out.println(stack+"stack값!!!!");
			System.out.println(result+"result값!!!!");
		}
		
		
		for(int i = 0; i < N; i++) {
			System.out.print(result.pop() + "마지막!!!");
		}

	}

}
