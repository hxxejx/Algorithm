package 구현;

import java.io.*;
import java.util.*;

public class S5_5800_성적통계 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int K = Integer.parseInt(br.readLine());
		
		for (int c = 1; c <= K; c++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int[] score = new int[N];
			
			for (int i = 0; i < N; i++) {
				score[i] = Integer.parseInt(st.nextToken());
			}
			
			int gap = 0;
			
			Arrays.sort(score);
			
			for (int i = N-1; i > 0; i--) {
				gap = Math.max(gap, score[i]-score[i-1]);
			}
			
			sb.append("Class " + c + "\n" + "Max " + score[N-1] + ", Min " + score[0] + ", Largest gap " + gap + "\n");
			
		}
		
		System.out.println(sb);

	}

}
