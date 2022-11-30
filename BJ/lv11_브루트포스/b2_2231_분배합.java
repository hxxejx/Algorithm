package lv11_브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b2_2231_분배합 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int result = 0;
		
		
		for(int i = 0; i<num; i++) {
			int N = i;
			int sum = 0;
			while(N!=0) { // *** i로 while 돌렸더니 틀림
				sum += N%10;
				N /= 10;		
			}
			if(sum+i==num) { // i의 분해합이 num과 같으면
				result = i; // *** 바로 i를 출력했더니 틀림
				break; // 가장 작은 수를 구해야 하기 때문에 skip
			}				
		}	 
		System.out.println(result); // num의 생성자 i 출력
	}
}
