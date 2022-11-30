package 카탈란수;

import java.io.*;
import java.util.*;

/*
 * 입력
 * 1. 테스트 케이스 T
 * 2. 괄호 문자열의 길이를 나타내는 L
 * 출력
 * 1. 길이가 L인 올바른 괄호 문자열의 개수를 1,000,000,007로 나눈 나머지
 * 
 * >> 첫번째 (와 i번째 ) 사이에 dp[i-2]개의 경우의 수 생김
 * i 이후의 문자열에는 dp[L-i]개의 경우의 수 생김
 * 
 * dp[i*2] += dp[j*2]*dp[(i-1-j)*2];
 */
public class G3_1670_정상회담2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		long[] dp = new long[10001];
		
		dp[0] = 1;
		dp[2] = 1;
		
		for(int i = 2; i <= 5000; i++) {
			for(int j = 0; j < i; j++) {
				dp[i*2] += dp[j*2]*dp[(i-1-j)*2];
				dp[i*2] %= 987654321;
			}
		}

		int N = Integer.parseInt(br.readLine());
		sb.append(dp[N]).append("\n");
		
		System.out.println(sb);

	}

}
