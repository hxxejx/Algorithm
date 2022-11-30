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
public class g2_11444_피보나치수6_2 {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        // (f(n+1) f(n)  ) = (1 1)n
        // (f(n)   f(n-1))   (1 0)

        long[][] ans = recur(N);
        System.out.println(ans[0][1]);

    }
	
	//피보나치수를 구하는 행렬
    public static long[][] base = new long[][]{{1, 1}, {1, 0}};
    
    //
    public static long[][] recur(long N){
        long[][] temp = null;
        if(N == 1) return base;
        if(N % 2 == 0){
            temp = recur(N/2);
            return multiply(temp, temp);
          //N이 홀수면 base 행렬 한 번 더 곱해 줌
        } else {
            temp = recur((N-1)/2);
            return multiply(base, multiply(temp, temp));
        }
    }

    // 행렬 곱 리턴
    public static long div = 1000000007;
    public static long[][] multiply(long[][] a, long[][] b){
        long[][] answer = new long[2][2];

        answer[0][0] = (a[0][0]*b[0][0] + a[0][1]*b[1][0])% div;
        answer[0][1] = (a[0][0]*b[0][1] + a[0][1]*b[1][1])% div;
        answer[1][0] = (a[1][0]*b[0][0] + a[1][1]*b[1][0])% div;
        answer[1][1] = (a[1][0]*b[0][1] + a[1][1]*b[1][1])% div;

        return answer;
    }

}