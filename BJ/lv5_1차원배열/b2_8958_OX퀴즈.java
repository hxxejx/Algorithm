package lv5_1차원배열;

import java.util.Scanner;

public class b2_8958_OX퀴즈 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		String[] arr = new String[T];
		
		for(int i = 0; i < T; i++) {
			arr[i] = sc.next();
		}
		
		for(int i = 0; i < T; i++) {
			int count = 0;
			int sum = 0;
			
			for(int j = 0; j<arr[i].length(); j++) {
				if(arr[i].charAt(j)=='O') {
					count++;
					
				} else {count = 0;}
				
				sum += count;
			}			
			System.out.println(sum);
		}
	}
}
