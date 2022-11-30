package 문제풀이;

import java.io.*;
import java.util.*;

public class S1_1790_수이어쓰기2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		String str = st.nextToken();
		long N = Integer.parseInt(str);
		long k = Integer.parseInt(st.nextToken());
		
//		int size = str.length();
//		
//		int ans =  9 * (int)Math.pow(10, size-2);
		
		long K = k;
		long num = 9;
		long size = 1;
		
		long ans = 0;
		
		while(true) {
			  if(K <= num * size) break;
			  ans += num;
			  K -= num * size;
			  num *= 10;
			  size++;
		}
		
		ans += (K-1) / size + 1;
		
//		long mod = 1;
//		
//		if(ans > N) System.out.println(-1);
//		else {
//			long result = 0;
//			long tmp = (K-1)%size + 1;
//			
//			for (int i = 0; i < size - 1; i++) {
//				mod *= 10;
//			}
//			
//			for (int i = 0; i < tmp; i++) {
//				result = ans / mod;
//				ans %= mod;
//				mod /= 10;
//			}
//			
//			System.out.println(result);
//			
//		}
		
		if(ans > N) {
			System.out.println(-1);
		}else {
			int idx = (int)((K-1)%size);
			System.out.println(String.valueOf(ans).charAt(idx));
		}
		

	}

}
