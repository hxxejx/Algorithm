package lv21_이분탐색;

import java.io.*;
import java.util.*;

/*
 * 입력
 * 1. 이미 가지고 있는 랜선 개수 K 필요한 랜선 개수 N
 * 2. 이미 가지고 있는 랜선의 길이
 * 출력
 * 1. N개를 만들 수 있는 랜선의 최대 길이
 * 조건
 * 1. 무조건 같은 길이로 만들어야 함
 */
public class s3_1654_랜선자르기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int[] len = new int[K];
		int length = 0;
		
		for(int i = 0; i<K; i++) {
			len[i] = Integer.parseInt(br.readLine());
			length += len[i];
		}
		
		int n = length/N;
		int ans = 0;
		
		for(int i = n; i>=0; i--) {
			int cnt = 0;
			for(int j = 0; j<K; j++) {
				cnt += len[j]/i;
			}
			if(cnt==N) {
				ans = i;
				break;
			}
		}
		
		System.out.println(ans);

	}

}
