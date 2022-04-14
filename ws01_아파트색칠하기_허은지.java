package com.ssafy;

import java.io.*;
import java.util.*;

/*
 * 2 3 5 8 13 ...
 * 피보나치
 * f(n) = f(n-1) + f(n-2)
 */
public class ws01_아파트색칠하기_허은지 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] DP = new int[N+2];
		
		DP[0] = 2;
		DP[1] = 3;
		
		for(int i = 2; i<N; i++) {
			DP[i] = DP[i-1] + DP[i-2];
		}
		
		System.out.println(DP[N-1]);

	}

}
