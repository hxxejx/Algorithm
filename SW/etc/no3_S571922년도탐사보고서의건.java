package 계절학기;

import java.io.*;
import java.util.*;

public class no3_S571922년도탐사보고서의건 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int F = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			
			int[] floor = new int[160];
			int[] hand = new int[N];
			
			st = new StringTokenizer(br.readLine());
			int size = st.countTokens();
			
			for (int i = 0; i < size; i++) {
				floor[i] = Integer.parseInt(st.nextToken());
				hand[floor[i]-1]++;
			}
			
			int max = 0;
			for (int i = 0; i < N; i++) {
				max = Math.max(max, hand[i]);
			}
			
			System.out.println(max);
			
			int removeHandIndex = 0;

			for (int i = 0; i < size; i++) {
				System.out.println("현재 손: " + floor[i]);
				if(hand[floor[i]-1]==max) {
					removeHandIndex = i;
					break;
				}
			}
			
			int cnt = 0;
			
			if(F > removeHandIndex) cnt = (F-1)%size + (F/size)%size;
			else cnt = F-1;
			
			int ans = floor[cnt];

			sb.append("#" + tc + " " + ans + "\n");
			
		}
		
		System.out.println(sb);
		
	}

}
