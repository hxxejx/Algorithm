package 문제풀이;

import java.io.*;
import java.util.*;

public class S1_11057_오르막수 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		// 한 자리에 0~9까지 들어갈 수 있기 때문에 N자리 수 10개
		int[][] dp = new int[N+1][10];
		
		// 첫 시작은 1
		for(int i = 0; i < 10; i++) {
			dp[0][i] = 1;
		}
		
		// 1부터 N까지
		for(int i = 1; i < N+1; i++) {
			for(int j = 0; j < 10; j++) {
				for(int k = j; k < 10; k++) {
					// 왼쪽에 있는 수(j)보다 크거나 같은 오른쪽에 있는 수(k)들(오르막 수) 전부 더하기
					dp[i][j] += dp[i-1][k];
					// 10007로 나눈 나머지 출력
					dp[i][j] %= 10007;
				}
			}
		}
		
		System.out.println(dp[N][0] % 10007); 

	}

}
