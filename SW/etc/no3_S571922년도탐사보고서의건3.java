package 계절학기;

import java.io.*;
import java.util.*;

public class no3_S571922년도탐사보고서의건2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int F = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			
			Queue<Integer> floor = new LinkedList<>();
			int[] hand = new int[N];
			
			st = new StringTokenizer(br.readLine());
			int s = st.countTokens();
			
			for (int i = 0; i < s; i++) {
				int num = Integer.parseInt(st.nextToken());
				floor.add(num);
				hand[num-1]++;
			}
			
			int num = 0;
			int cnt = 0;
			
			outer: while(true) {
				int max = 0;
				for (int j = 0; j < N; j++) {
					max = Math.max(max, hand[j]);
				}
				
				boolean remove = false;
				int size = floor.size();
				
				for (int j = 0; j < size; j++) {
					cnt++;
					num = floor.poll();
					if(!remove && hand[num-1]==max) {
						remove = true;
						hand[num-1]--;
						continue;
					}
					floor.add(num);
					if(cnt==F) break outer;
				}
			}
			
			sb.append("#" + tc + " " + num + "\n");
			
		}
		
		System.out.println(sb);
		
	}

}
