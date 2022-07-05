package com.ssafy.im;

import java.util.*;
import java.io.*;

/*
 * 입력
 * 1. 테스트 케이스 T
 * 2. 무게추의 개수 N
 * 3. 무게추의 무게 N개
 * 출력
 * 오른쪽 위에 올라가 있는 무게의 총합이 왼쪽에 올라가 있는 무게의 총합보다 커지지 않은 경우의 수
 * "#" + tc + " " + result;
 * 
 * >> 오른쪽에 올라가 있는 무게의 총합이 더 크면 카운트 안 세기
 * >> 부분집합
 */
public class D4_3234_준환이의양팔저울_허은지 {
	static int N, ans;
	static List<Integer> list;
	static boolean[] isSelected;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("D4_3234_준환이의양팔저울.txt"));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		list = new ArrayList<>();
		
		for(int tc = 1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			
			isSelected = new boolean[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i<N; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			
			scale(0);
			
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
			
		}
		
		System.out.println(sb);
	}

	private static void scale(int cnt) {
		int left = 0;
		int right = 0;
		if(cnt==N) {
			for(int i = 0; i<N; i++) {
				if(isSelected[i]) left += list.get(i); //왼쪽
				else right += list.get(i);
				
				if(right <= left) ans++;
			}
			return;
		}
		isSelected[cnt] = true;
		scale(cnt+1);
		isSelected[cnt] = false;
		scale(cnt+1);

	}

	private static void weight() {
		
		
	}
	
	
}
