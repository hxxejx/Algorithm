package com.ssafy.boj;

import java.util.*;
import java.io.*;

/*
 * 입력
 * 1. 영상의 크기 N(2의 제곱수)
 * 2. 길이 N의 문자열 N개
 * 출력
 * 쿼드 트리 구조 압축 결과
 */
public class BJ_1992_쿼드트리_허은지 {
	static StringBuilder sb = new StringBuilder();
	static int[][] arr;
	static int num;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		arr = new int[N][N];
		
		for(int i = 0; i<N; i++) {
			String str = br.readLine();
			for(int j = 0; j<N; j++) {
				arr[i][j] = str.charAt(j)-'0';
			}
		}
		
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
		
		qt(0, 0, N);
		
		System.out.println(sb);
	}
	
	private static void qt(int x, int y, int n) {
		if(check(x,y,n)) {
			sb.append(num);
		} else {
			sb.append('(');
	        int size = n / 2;
			for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    qt(x + size * i, y + size * j, size);
                }
            }
	        sb.append(')');
		}
	}

	private static boolean check(int x, int y, int n) {
		int tmp = arr[x][y];
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (num != arr[i][j]) {
                    return false;
                }
            }
        }
        num = tmp;
        return true;
	}

}
