package lv21_이분탐색;

import java.io.*;
import java.util.*;

public class g2_1300_K번째수 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());

//		int[] B = new int[N*N];
//		
//		for(int i = 0; i<N; i++) {
//			for(int j = 0; j<N; j++) {
//				B[i*N+j] = (i+1)*(j+1);
//			}
//		}
//		
//		Arrays.sort(B);
//
//		System.out.println(B[k]);
		
		long min = 1;
		long max = k;
		
		while(min < max) {
			
			long mid = (min + max) / 2;
			long count = 0;

			for(int i = 1; i <= N; i++) {
				count += Math.min(mid / i, N);
			}

			if(k <= count) max = mid;
			else min = mid + 1;
		}
				
		System.out.println(min);
		
	}

}
