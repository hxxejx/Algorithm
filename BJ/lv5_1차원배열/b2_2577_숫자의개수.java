package lv5_1차원배열;

import java.util.Scanner;

public class b2_2577_숫자의개수 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		int mul = a*b*c;
		
		int[] arr = new int[10];
		
		while(mul!=0) {
			arr[mul%10]++;
			mul/=10;
		}
		
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}

	}

}
