package lv5_1차원배열;

import java.util.Scanner;

public class b1_4344_평균은넘겠지 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int C = sc.nextInt();
		int[] score;				
		
		for(int k = 0; k < C; k++) {
			int N = sc.nextInt();
			score = new int[N];

			double sum = 0;
			
			for(int i = 0; i < N ;i++) {
				score[i] = sc.nextInt();
				sum += score[i];
			}
			
			double avg = sum/N;
			double cnt = 0;		
			
			for(int j = 0; j < N; j++) {
				if(avg<score[j]) {
					cnt++;
					}
			}
			
			System.out.printf("%.3f%%\n", (cnt/N)*100);
			
		}
	}
}
