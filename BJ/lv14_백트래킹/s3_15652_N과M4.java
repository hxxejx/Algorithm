package lv14_백트래킹;

import java.util.*;
import java.io.*;


public class s3_15652_N과M4 {
	
	static int N, M;
	static int[] input;
	static int[] result;
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		input = new int[N];
		result = new int[M];
		
		for(int i = 0; i<N; i++) {
			input[i] = i+1;
		}
		
		cal(0, 0);
		
		System.out.println(sb);
	}

	private static void cal(int cnt, int start) {
		if(cnt==M) {
			for(int i = 0; i < M; i++) {
				sb.append(result[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for(int i = start; i < N; i++) {
			result[cnt] = input[i];
			cal(cnt+1, i);
		}
		
	}
}