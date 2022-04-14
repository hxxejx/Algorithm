package im형필수문제;

import java.io.*;
import java.util.*;

/*
 * 입력
 * 1. 수열의 길이 N
 * 2. N개의 숫자가 빈칸을 두고 주어짐(0~9)
 * 출력
 * 1. 가장 긴 길이
 * 조건
 * 1. 연속해서 커지거나(같은 것 포함) 연속해서 작아지는(같은 것 포함)중 가장 길이가 긴 것을 찾아내어 길이를 출력
 * 
 * >> 큰 것과 작은 것 두 개로 나눠서 둘 중에서 큰 것 출력
 */
public class s3_2491_수열 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());

		int[] num = new int[N];
		int upCnt = 1;
		int downCnt = 1;
		int result = 0;

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		if(N==1) {
			System.out.println(1);
			System.exit(0);
		}

		for (int i = 0; i < N-1; i++) {		
			if (num[i] <= num[i + 1]) upCnt++; //연속해서 커지는 숫자 찾기
			else upCnt =1;
			result = Math.max(upCnt, result);
		}

		for (int i = 0; i < N-1; i++) {			
			if (num[i] >= num[i + 1]) downCnt++; //연속해서 작아지는 숫자 찾기
			else downCnt = 1;
			result = Math.max(downCnt, result);
		}
		System.out.println(result);
	}
}
