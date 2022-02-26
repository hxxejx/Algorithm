package com.ssafy.bj;

import java.io.*;
import java.util.*;

/*
 * 입력
 * 1. 빙고판에 적힌 숫자
 * 2. 사회자가 부르는 숫자
 * 출력
 * 1. 사회자가 몇 번째 수를 외친 뒤 빙고를 외치는지 출력
 */
public class BJ_2578_빙고_허은지 {
	static int[][] bingo;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		bingo = new int[5][5];
		
		for(int i = 0; i<5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j<5; j++) {
				bingo[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i<5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 1; j<=5; j++) {
				int num = Integer.parseInt(st.nextToken());
				
				for(int k = 0; k<5; k++) {
					for(int l = 0; l<5; l++) {
						if(num==bingo[k][l]) bingo[k][l] = 0;
					}
				}
				
				if(check()) {
					System.out.println(i*5+j);
					System.exit(0);
					
				}
				
			}
		}

	}

	private static boolean check() {
		int count = 0;
		int x = 0;
		int y = 0;
		
		//
		outer: for(int i = 0; i<5; i++) {
			for(int j = 0; j<5; j++) {
				if(bingo[i][j]!=0) continue outer;
			}
			count++;
		}
		
		outer: for(int i = 0; i<5; i++) {
			for(int j = 0; j<5; j++) {
				if(bingo[j][i]!=0) continue outer;
			}
			count++;
		}
		
		outer: if(bingo[0][0]==0) {
			for(int i = 1; i<5; i++) {
				if(bingo[i][i]!=0) break outer;
			}
			count++;
		}
		
		outer: if(bingo[4][0]==0) {
			for(int i = 1; i<5; i++) {
				if(bingo[4-i][i]!=0) break outer;
			}
			count++;
		}
		
		if(count>=3) return true;
		return false;
	}

}
