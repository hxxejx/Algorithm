package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S5_17478_재귀함수가뭔가요 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
		
		Function(N, 0); // N번 반복, 라인은 0번부터

	}

	public static void Function(int num, int line) {
		if(num == 0) {
			Underbar(line);
			System.out.println("\"재귀함수가 뭔가요?\"");
			Underbar(line);
			System.out.println("\"재귀함수는 자기 자신을 호출하는 함수라네\"");
			Underbar(line);
			System.out.println("라고 답변하였지.");
			return;
		} else {
			Underbar(line);
			System.out.println("\"재귀함수가 뭔가요?\"");
			Underbar(line);
			System.out.println("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.");
			Underbar(line);
			System.out.println("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.");
			Underbar(line);
			System.out.println("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"");
			
			Function(num-1, ++line); // 라인 늘어나면서 재귀
			
			Underbar(--line); //라인 줄어들기
			System.out.println("라고 답변하였지.");
		}		
	}
	
	public static void Underbar(int line) {
		for(int i = 0; i < line; i++) { //라인 점점 늘어나면서 출력
			System.out.print("____");
		}
	}
}
