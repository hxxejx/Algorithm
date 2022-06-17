package 문제풀이;

import java.io.*;
import java.util.*;

public class S2_1124_언더프라임 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		for (int i = A; i <= B; i++) {
			boolean[] prime = new boolean[B+1];
			
			prime[0] = prime[1] = true;
			
			int cnt = 0;
			
			for (int j = 2; j <= Math.sqrt(i); j++) {
				while(i%j == 0) {
					cnt++;
					i /= j;
				}
			}
			
			if(i!=1) cnt++;  
			
			
		}

	}

}
