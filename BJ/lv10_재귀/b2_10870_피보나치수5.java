package lv10_재귀;

import java.util.Scanner;

public class b2_10870_피보나치수5 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int sum = 1;
		
		for(int i = 1; i <= N; i++) {
            sum *= i;
		}	
		System.out.print(sum);
	}
}
