package lv12_정렬;

import java.util.Scanner;

public class b1_2750_수정렬하기 {

	/*
	 * 1. N만큼 for문 돌리기
	 * 2. 배열에 숫자 넣기
	 * 3. tmp 사용해서 오름차순 정렬
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] num = new int[N];
		
		for(int i = 0; i<N; i++) {
			num[i] = sc.nextInt();
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = i+1; j < N; j++) {
				if(num[i] > num[j]) {
					int tmp = num[i];
					num[i] = num[j];
					num[j] = tmp;
				}
			}
		}
		for(int i = 0; i < N; i++) {
			System.out.println(num[i]);
		}
	}
}
