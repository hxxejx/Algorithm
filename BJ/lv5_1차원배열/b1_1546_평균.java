package lv5_1차원배열;

import java.util.Scanner;

public class b1_1546_평균 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		double sum = 0;
		int M = 0;
		
		for(int i = 0; i < T; i++) {
			int num = sc.nextInt();
			if(M<num) {M = num;}
			sum += num;
		}
		
		double avg = sum/M*100/T;

		System.out.println(avg);

	}

}
