package 문제풀이;

import java.io.*;
import java.util.*;

public class B2_2908_상수 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n1 = Integer.parseInt(st.nextToken());
		int n2 = Integer.parseInt(st.nextToken());
		
		int tmp = n1/100;
		n1 = ((n1%100)%10)*100 + ((n1%100)/10)*10 + tmp;
		
		tmp = n2/100;
		n2 = ((n2%100)%10)*100 + ((n2%100)/10)*10 + tmp;
		
		if(n1 > n2) System.out.println(n1);
		else System.out.println(n2);

	}

}
