package lv15_동적계획법1;

import java.io.*;
import java.util.*;

/*
 * 입력
 * 1. 계단의 개수 N
 * 2. 제일 아래에 놓인 계단부터 계단에 쓰여 있는 점수
 * 출력
 * 1. 계단 오르기 게임에서 얻을 수 있는 총 점수의 최댓값
 * 조건
 * 1. 한 계단 혹은 두 계단씩 오를 수 있다
 * 2. 연속된 세 개의 계단을 모두 밟으면 안 된다
 * 3. 마지막 도착 계단은 반드시 밟아야 한다
 */
public class s3_2579_계단오르기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		 
		int[] DP = new int[N + 1];
		int[] arr = new int[N + 1];
 
 
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
 

		DP[1] = arr[1];
		
		if (N >= 2) {
			DP[2] = arr[1] + arr[2];
		}
 
		for (int i = 3; i <= N; i++) {
			DP[i] = Math.max(DP[i - 2] , DP[i - 3] + arr[i - 1]) + arr[i];
		}
 
		System.out.println(DP[N]);
	}

}
