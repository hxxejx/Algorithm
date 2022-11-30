package 구현;

import java.io.*;
import java.util.*;

public class S5_1475_방번호 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String N = br.readLine();
		
		int[] number = new int[10];
		
		for (int i = 0; i < N.length(); i++) {
			int index = N.charAt(i) - '0';
			number[index]++;
		}

		int set = (int) Math.ceil((double)(number[6] + number[9])/2);
		
		for (int i = 0; i < 10; i++) {
			if(i != 6 && i != 9 && set < number[i]) set = number[i];
		}
		
		System.out.println(set);

	}

}
