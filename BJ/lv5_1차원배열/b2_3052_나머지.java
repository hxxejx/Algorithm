package lv5_1차원배열;

import java.util.Scanner;

public class b2_3052_나머지 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] num = new int[10];
		int[] arr = new int[42];
		int result = 0;
		
		for(int i = 0; i < 10; i++) {
			num[i] = sc.nextInt();
			arr[num[i]%42]++;
		}
		
		for(int i = 0; i < 42; i++) {
			if(arr[i]!=0) {
				result++;
			}
		}
		
		System.out.println(result);

	}

}
