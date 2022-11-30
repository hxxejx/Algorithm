package boj_미완;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class s2_18870_좌표압축 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 숫자 개수 N
		int[] num = new int[N]; // 숫자 담을 배열
		int[] num2 = new int[N];
		
		StringTokenizer st;
		
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			num[i] = Integer.parseInt(st.nextToken());
		} 
		
		num2 = num; //원본 남겨두기
		
		Arrays.sort(num2); // 정렬
		
		for(int i = 0; i < N; i++) {
			if(!(num2[i]==num2[i-1])) { // 중복 지우기
				// 중복 지워서 값이 오름차순으로 들어오면 배열에 하나씩 넣기.. 되나
				// a[0] a[1] a[2] 이런 식으로 들어오면 출력하려고 했는데 안됨!!
				// Map 사용하기
			}
			
		}

	}

}

//package lv12_정렬;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.StringTokenizer;
//
///*
// * 1. 첫째줄에 숫자 N
// * 2. 공백으로 구분된 X
// * 3. 가장 작은 숫자부터 순위 구하기
// * 
// * >> Collections.sort
// */
//public class s2_18870_좌표압축 {
//
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();
//		
//		int N = Integer.parseInt(br.readLine());
//		
//		ArrayList<Integer> num = new ArrayList<>();
//		
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		for(int i = 0; i<N; i++) {
//			
//			num.add(Integer.parseInt(st.nextToken()));
//		}
//		
//		Collections.sort(num);
//		
//		int count = 1;
//		
//		sb.append(0).append(" ");
//		for(int i = 1; i<N; i++) {
//			if(num.get(i)!=num.get(i-1)) {
//				sb.append(count).append(" ");
//				count++;
//			}
//		}
//		System.out.println(sb);
//
//	}
//
//}
//
