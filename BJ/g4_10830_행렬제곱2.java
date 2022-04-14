package lv20_분할정복;

import java.io.*;
import java.util.*;

/*
 * 입력
 * 1. 행렬의 크기 N과 제곱승 B
 * 2. N개의 줄에 행렬의 각 원소
 * 출력
 * 1. 행렬 A를 B제곱한 결과
 * 조건
 * 1. 각 원소를 1000으로 나눈 나머지
 */
public class g4_10830_행렬제곱2 {
	static int N;
	static long B;
	static int[][] A, ans;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		B = Long.parseLong(st.nextToken());
		
		A = new int[N][N];
		
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken())%1000;
			}
		}
		
		if(B==1) {
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<N; j++) {
					sb.append(A[i][j]%1000).append(" ");
				}
				sb.append("\n");
			}
			
			System.out.println(sb);
			
			System.exit(0);
		}
		
		int[][] ans = squared(A, B);

		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				sb.append(ans[i][j]%1000).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);

	}

	private static int[][] squared(int[][] a, long cnt) {
		if(cnt==1L) return a;
		int[][] ans = squared(a, cnt/2);
		ans = mul(ans, ans);
		
		if(cnt % 2 == 1L) {
			ans = mul(ans, a);
		}
		
		return ans;
	}

	private static int[][] mul(int[][] o1, int[][] o2) {
		int[][] ans = new int[N][N];
		
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				for(int k = 0; k<N; k++) {
					ans[i][j] += o1[i][k]*o2[k][j];
					ans[i][j] = ans[i][j]%1000;
				}
			}
		}
		return ans;
	}

}
