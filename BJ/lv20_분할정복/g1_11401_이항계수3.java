package lv20_분할정복;

import java.util.*;
import java.io.*;

/*
 * 입력
 * 1. 자연수 N과 정수 K
 * 출력
 * 1. 1,000,000,007로 나눈 나머지
 * 
 * >> 이항계수 => 조합
 * >> 페르마의 소정리
 * a는 정수, p는 소수이며 a가 p의 배수가 아닐 때
 * a^p=a (mod p) p로 나눈 나머지가 a^p와 a가 같다
 * a^p-1 = 1 (mod p) p로 나눈 나머지가 a^p-1과 1가 같다
 * 
 */
public class g1_11401_이항계수3 {

	final static long P = 1000000007;
	public static void main(String[] args) throws Exception {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		long N = Long.parseLong(st.nextToken());
		long K = Long.parseLong(st.nextToken());
		
		long numer = factorial(N);
		
		long denom = factorial(K) * factorial(N - K) % P;	
	
		System.out.println(numer * pow(denom, P - 2) % P);
		
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