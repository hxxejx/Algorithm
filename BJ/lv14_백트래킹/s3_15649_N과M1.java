package lv14_백트래킹;

import java.util.*;
import java.io.*;

//순열 Permutation
public class s3_15649_N과M1 {
	
	static int N, M;
	static int[] input;
	static int[] result;
	static boolean[] isSelected;
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		input = new int[N];
		result = new int[M];
		isSelected = new boolean[N];
		
		for(int i = 0; i < N; i++) {
			input[i] = i+1;
		}
		
		P(0);
		
		System.out.println(sb);
		
	}

	private static void P(int cnt) {
		if(cnt==M) {
			for(int i = 0; i < M; i++) {
				sb.append(result[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for(int i = 0; i < N; i++) {
			if(isSelected[i]) continue;
			result[cnt] = input[i];
			isSelected[i] = true;
			P(cnt+1);
			isSelected[i] = false;
		}
	}
}
