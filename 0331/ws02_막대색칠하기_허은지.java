package com.ssafy;

import java.io.*;
import java.util.*;

/*
 * 2 5 12 29...
 * f(n) = f(n-1)*2 + f(n-2)
 */
public class ws02_막대색칠하기_허은지 {

	static int dp[][];
	public static void main(String[] args) {
		dp = new int [7][3];
		
		dp[1][0] = 1;
		dp[1][1] = 1;
		dp[1][2] = 0;
		for(int i = 2; i <= 6; i++) {
			dp[i][0] = dp[i-1][0] + dp[i-1][1] + dp[i-1][2];
			dp[i][1] = dp[i-1][0] + dp[i-1][1] + dp[i-1][2];
			if(i == 2) {
				dp[i][2] = 1;
			}
			else
				dp[i][2] = dp[i-2][0] + dp[i-2][1] + dp[i-2][2];
		}

		System.out.println(dp[6][0] + dp[6][1] +dp[6][2] );
	}

}
