package lv6_함수;

import java.util.Scanner;

/*
 * 1. 배열에 숫자 하나씩 넣기
 * 2. 100보다 작은 경우 99까지 모두 한수이므로 그대로 출력
 * 3. 100보다 큰 경우 99 + 배열간 차이 비교해서 같으면 더하기
 * 4. 1000은 등차수열이 아니므로 예외
 */
public class s4_1065_한수 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 1
		int[] arr = new int[3];
		int result = 0;
		
		if(N<100) {
			System.out.println(N); // 2
		} else {
			result = 99; //  100보다 큰 경우 99+
			
			if(N == 1000) { N = 999;} //4
			
			for(int i = 100; i <= N; i++) {
				arr[0] = i%10; //1의 자리
				arr[1] = (i/10)%10; //10의 자리
				arr[2] = (i/100)%10; //100의 자리
					
				if(arr[0]-arr[1] == arr[1]-arr[2]) { //등차수열 구하기
						result++; //맞으면 개수 +1
				}
			}
			System.out.println(result);
		}
		
	}
}
