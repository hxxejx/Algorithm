package lv5_1차원배열;

import java.util.Scanner;

public class b2_2562_최댓값 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int max = 0;
		int count = 0;
		
		for(int i = 0; i<9; i++) {
			int num = sc.nextInt();
			if(max < num) {max = num; count = i+1;}
		}
		System.out.printf("%d\n%d", max, count);
	}

}
