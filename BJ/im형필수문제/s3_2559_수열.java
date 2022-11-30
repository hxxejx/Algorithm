package im형필수문제;

import java.util.*;
import java.io.*;

/*
 * 입력
 * 1. 온도를 측정한 전체 날짜의 수 N 합을 구하기 위한 연속적인 날짜의 수 K
 * 2. 매일 측정한 온도를 나타내는 N개의 정수
 * 출력
 * 1. 연속적인 K일의 온도의 합이 최대가 되는 값
 * 
 * >> 각 값의 합을 구해서 max값 찾기
 */
public class s3_2559_수열 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int max = Integer.MIN_VALUE;
		
		for(int i = 0; i <= N-K; i++) {
			int sum = 0;
			for(int j = i; j < i+K; j++) {
				sum += arr[j];
			}
			max = Math.max(sum, max);
		}
		System.out.println(max);
	}
}
