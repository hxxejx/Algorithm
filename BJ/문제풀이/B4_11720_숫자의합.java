package 문제풀이;

import java.io.*;
import java.util.*;

public class B4_11720_숫자의합 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		String str = br.readLine();
		
		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum += str.charAt(i) - '0';
		}
		
		System.out.println(sum);

	}

}
