package boj_미완;

import java.io.*;
import java.util.*;

/*
 * 
 */
public class s2_11053_가장긴증가하는부분수열 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int A = Integer.parseInt(br.readLine());
		int[] arr = new int[A];
		int[] DP = new int[A];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<A; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		DP[0] = 1;
		int max = 1;
		
		for(int i = 0; i<A-1; i++) {
			int tmp = 0;
			// j+1부터 말고 0부터 시작해서 i까지 비교하기
			for(int j = i+1; j<A; j++) {
				if(arr[i]<arr[j] && tmp<arr[j]) {
					tmp = i;
					DP[j] = DP[i]++;
					max = Math.max(max, DP[j]);
					//System.out.println(arr[j] + " " + DP[j] + " " + max);
				} else if(arr[i]<arr[j] && tmp>arr[j]) {
					DP[j] = DP[tmp]++;
					max = Math.max(max, DP[j]);
				}
				
			}
			//System.out.println("--------------");
		}
		
		System.out.println(max);

	}

}
