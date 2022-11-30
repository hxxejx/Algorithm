package 문제풀이;

import java.io.*;
import java.util.*;

public class S4_1302_베스트셀러 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] cnt = new int[N];
		int max = Integer.MIN_VALUE;
		
		String[] book = new String[N];
		
		outer: for (int i = 0; i < N; i++) {
			book[i] = br.readLine();
			for (int j = 0; j < i; j++) {
				if(book[j].equals(book[i])) {
					System.out.println(book[i]);
					cnt[j]++;
					max = Math.max(max, cnt[j]);
					continue outer;
				}
			}
			cnt[i]++;
			max = Math.max(max, cnt[i]);
		}
		
		for (int i = 0; i < N; i++) {
			if(cnt[i] == 0) break;
			System.out.println(book[i]);
		}
		
		int k = 0;
		
		for (int i = 0; i < N; i++) {
			if(cnt[i] == 0) break;
			if(max == cnt[i]) {
				k++;
			}
		}
		
		String[] ans = new String[k];
		
		k = 0;
		
		for (int i = 0; i < N; i++) {
			if(cnt[i] == 0) break;
			if(max == cnt[i]) {
				ans[k] = book[i];
				k++;
			}
		}
		
		Arrays.sort(ans);
		
		for (int i = 0; i < k; i++) {
			System.out.println(ans[i]);
		}
		
		System.out.println(ans[0]);

	}

}
