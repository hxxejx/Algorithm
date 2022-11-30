package 문제풀이;

import java.io.*;
import java.util.*;

public class S3_11051_이항계수2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		long ans = factorial(N) / (factorial(N - K) * factorial(K));
		
		System.out.println(ans);
		
	}
 
	static long factorial(int N) {
		if (N <= 1)	return 1;
		return N * factorial(N - 1) % 10007;
	}
	
}