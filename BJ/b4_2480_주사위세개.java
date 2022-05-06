package 구현;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		int money = 0;
		
		if(A==B && B==C) money = 10000+(A*1000);
		else if(A==B) money = 1000+(A*100);
		else if(B==C) money = 1000+(B*100);
		else if(C==A) money = 1000+(C*100);
		else {
			money = Math.max(A, Math.max(B, C))*100;
		}
		
		System.out.println(money);
	}

}
