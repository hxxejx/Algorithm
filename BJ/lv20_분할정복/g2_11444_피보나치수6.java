package lv20_분할정복;

import java.io.*;
import java.util.*;

/*
 * 입력
 * 1. n
 * 출력
 * 1. n번째 피보나치수를 1000000007로 나눈 나머지
 * 
 * >> 0 1 1 2 3 5 8 13 21 34 55
 */
public class g2_11444_피보나치수6 {
	final static long d = 100000007;
	static long ans;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long N = Long.parseLong(br.readLine());
		
		Fibo(N);
		
		System.out.println(ans%d);

	}

	private static long Fibo(long n) {
		if(n==0) return 0;
		if(n==1L) return 1;
		ans += (Fibo(n)*Fibo(n) + Fibo(n-1)*Fibo(n-1))%d;
		n /= 2;
		
		return ans;
		
	}

}
