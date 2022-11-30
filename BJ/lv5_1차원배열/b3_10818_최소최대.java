package lv5_1차원배열;

import java.util.Scanner;

public class b3_10818_최소최대 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int min = 1000000;
		int max = -1000000;
		
		for(int i = 0; i < N; i++) {
            int num = sc.nextInt();
			//최솟값 구하기
			if(num<min) {min = num;}
			//최댓값 구하기
			if(num>max) {max = num;}	
		}	
		System.out.printf("%d %d", min, max);
	}
}
