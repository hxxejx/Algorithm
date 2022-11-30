package 구현;

import java.io.*;
import java.util.*;

/*
 * 입력
 * 1. 테스트 케이스 t
 * 2. 메모리크기m 프로그램코드의크기c 입력의크기i
 * 3. 프로그램
 * 4. 프로그램의입력
 * 출력
 * 1. 프로그램종료 Terminates 무한루프 Loops 어느부분이 무한 루프인지 숫자로 출력
 * 조건
 * 1. - 포인터가 가리키는 수를 1 감소 + 1 증가
 * 2. < 왼쪽 > 오른쪽 범위를 벗어나면 반대쪽으로 넘어감
 * 3. [ 포인터의 값이 0이라면 ]으로 점프
 * 4. ] 포인터의 값이 0이 아니라면 [으로 점프
 * 5. . 포인터가 가리키는 수 출력 >> 무시
 * 6. , 문자를 읽고 포인터가 가리키는 곳에 저장 입력의 마지막인 경우 255 저장
 */
public class g1_3954_인터프리터 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		test: for(int tc = 0; tc<T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int i = Integer.parseInt(st.nextToken());
			
			int[] arr = new int[m];
			char[] code = new char[c];
			int[] bracket = new int[c];
			Stack<Integer> stack = new Stack<>();
			
			String str = br.readLine();
			for(int k = 0; k<c; k++) {
				code[k] = str.charAt(k);
				if(code[k]=='[') stack.push(k);
				else if(code[k]==']') {
					int tmp = stack.pop();
			        bracket[k] = tmp;
			        bracket[tmp] = k;
				}
			}
			
			st = new StringTokenizer(br.readLine());
			
			int pointer = 0; // 배열의 포인터값
			int codeIndex = 0; // 코드의 인덱스값
			int memory = 0; // 메모리
			int close = 0;
			boolean loop = false;
			
			while(true) {
				if(!loop && codeIndex==c) {
					sb.append("Terminates\n");
					continue test;
				} else if(memory>50000000) {
					if(!loop) {
						memory = 0;
						loop = true;
					} else break;
				}
				
				switch(code[codeIndex]) {
					case '-':
						arr[pointer] = (arr[pointer]-1)%256;
						break;
					case '+':
						arr[pointer] = (arr[pointer]+1)%256;
						break;
					case '<':
						pointer = (pointer+m-1)%m;
						break;
					case '>':
						pointer = (pointer+1)%m;
						break;
					case '[':
						if(arr[pointer]==0) codeIndex = bracket[codeIndex];
						break;
					case ']':
						if(loop && close < codeIndex) close = codeIndex;
						if(arr[pointer]!=0) codeIndex = bracket[codeIndex];
						break;
					case '.':
						break;
					case ',':
						if(!st.hasMoreTokens()) arr[pointer] = 255;
						else arr[pointer] = st.nextToken().charAt(0);
						break;
				}
				
				codeIndex++;
				memory++;
			}
			
			sb.append("Loops " + bracket[close] + " " + close + "\n");
			
		}
		
		System.out.println(sb);

	}

}
