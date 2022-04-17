package com.ssafy.sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D3_5607_조합_허은지 {

	final static long P = 1000000007;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			long N = Long.parseLong(st.nextToken());
			long K = Long.parseLong(st.nextToken());
			
			long numer = factorial(N);
			
			long denom = factorial(K) * factorial(N - K) % P;	
			
			sb.append("#" + tc + " " + numer * pow(denom, P - 2) % P + "\n");

		}
		
		System.out.println(sb);
	}
	
	public static long factorial(long N) {
		long fac = 1L;
		
		while(N > 1) {
			fac = (fac * N) % P;
			N--;
		}
		return fac;
	}
	
	public static long pow(long base, long expo) {
	    long result = 1;    
	    
	    while (expo > 0) {
	        if (expo % 2 == 1) {
	            result *= base;
	            result %= P;
	        }
	        base = (base * base) % P;
	        expo /= 2;
	    }
	    
	    return result;
	}
 
}