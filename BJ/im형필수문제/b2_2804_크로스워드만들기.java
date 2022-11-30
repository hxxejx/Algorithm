package im형필수문제;

import java.util.*;
import java.io.*;

/*
 * 입력
 * 1. 두 단어 A B
 * 출력
 * 크로스 워드
 * 
 * >> 두 단어 사이에 겹치는 단어를 찾아(가장 처음 나온 단어) 크로스 워드를 만든다
 * >> 나머지 글자는 .으로 출력한다
 */
public class b2_2804_크로스워드만들기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		String A = st.nextToken();
		String B = st.nextToken();
		
		char[] wordA = new char[A.length()];
		char[] wordB = new char[B.length()];
		
		wordA = A.toCharArray();
		wordB = B.toCharArray();
		
		int numA = 0;
		int numB = 0;
		
		outer: for(int i = 0; i < A.length(); i++) {
			for(int j = 0; j < B.length(); j++) {
				if(wordA[i]==wordB[j]) { //글자가 같으면 해당하는 행과 열 뽑기
					numA = j;
					numB = i;
					break outer; //제일 처음 것만 보면 되기 때문에 break
				}
			}
		}
		
		for(int i = 0; i < B.length(); i++) {
			for(int j = 0; j < A.length(); j++) {
				if(i==numA) sb.append(wordA[j]);
				 else if(j==numB) sb.append(wordB[i]);
				 else sb.append(".");
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}
}
