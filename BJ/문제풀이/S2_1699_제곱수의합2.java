package 문제풀이;

import java.io.*;
import java.util.*;

public class S2_1699_제곱수의합2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int cnt = 0;
		
		while(N>=4) {
			N -= Math.pow((int)Math.sqrt(N), 2);
			cnt++;
		}
		
		cnt += N;
		
		System.out.println(cnt);

	}

}
