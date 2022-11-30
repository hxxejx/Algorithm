package 문제풀이;

import java.io.*;
import java.util.*;

public class B2_2908_상수 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 1번 방법
		int n1 = Integer.parseInt(st.nextToken());

		int tmp = n1/100; // 100의자리 -> 1의자리
		n1 = ((n1%100)%10)*100 + // 1의 자리 -> 100의 자리
				((n1%100)/10)*10 + // 10의 자리 -> 10의 자리
					tmp; // 1의 자리 -> 1의 자리
		
		// 2번 방법
		String str = st.nextToken();
		int n2 = 0;
		
		for (int i = 0; i < 3; i++) {
			// 100의자리수는 0번째 자리기 때문에 0번째 자리 수*10의 0승
			// 10의자리수는 1번째 자리기 때문에 1번째 자리 수*10의 1승
			// 1의자리수는 2번째 자리기 때문에 2번째 자리 수*10의 2승
			n2 += (int)Math.pow(10, i) * (str.charAt(i) - '0');
			System.out.println(n2);
		}
		
		if(n1 > n2) System.out.println(n1);
		else System.out.println(n2);

	}

}
