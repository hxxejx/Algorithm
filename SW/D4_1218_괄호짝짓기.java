package com.ssafy.im;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.EmptyStackException;
import java.util.Stack;

public class D4_1218_괄호짝짓기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		File file = new File("D4_1218_괄호짝짓기.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		outer: for(int tc = 1; tc <= 10; tc++) { 
			int len = Integer.parseInt(br.readLine()); //문장 길이
			String str = br.readLine();
			Stack<String> stack = new Stack<>();
			for(int i = 0; i<len; i++) {
				char c = str.charAt(i); //한글자씩 읽기
				
				switch(c) {
				case '(': // ( 일때 쌓기
					stack.push("(");
					break;
				case ')':				
					try {
						if(stack.peek().equals("(")) stack.pop(); //가장 위에 있는 게 ( 일 때 ) 만나서 삭제
						else {System.out.println("#" + tc + " 0"); continue outer;} //아니면 0 출력
					} catch(EmptyStackException e) {
						System.out.println("#" + tc + " 0"); //stack 벗어나면 0 출력
						continue outer;
					}
					break;
				case '[':
					stack.push("[");
					break;
				case ']':
					try {
						if(stack.peek().equals("[")) stack.pop();
						else {System.out.println("#" + tc + " 0"); continue outer;}
					} catch(EmptyStackException e) {
						System.out.println("#" + tc + " 0");
						continue outer;
					}
					break;
				case '{':
					stack.push("{");
					break;
				case '}':
					try {
						if(stack.peek().equals("{")) stack.pop();
						else {System.out.println("#" + tc + " 0"); continue outer;}
					} catch(EmptyStackException e) {
						System.out.println("#" + tc + " 0");
						continue outer;
					}
					break;
				case '<':
					stack.push("<");
					break;
				case '>':
					try {
						if(stack.peek().equals("<")) stack.pop();
						else {System.out.println("#" + tc + " 0"); continue outer;}
					} catch(EmptyStackException e) {
						System.out.println("#" + tc + " 0");
						continue outer;
					}
					break;
				}
			}
			
			if(stack.empty()==true) { System.out.println("#" + tc + " 1");} // 스택 비어있으면 1
			else { System.out.println("#" + tc + " 0");} // 남아있으면 0
		}
	}
}
