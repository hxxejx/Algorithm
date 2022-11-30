package lv10_재귀;

import java.util.Scanner;

public class b3_10872_팩토리얼 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[] arr = new int[N+1];
		
		for(int i = 0; i < N+1; i++) {
			if(i==0) { arr[0] = 0; }
			else if(i==1) { arr[1] = 1; }
			else { arr[i] = arr[i-1] + arr[i-2];}           
		}
		System.out.print(arr[N]);
	}
}

