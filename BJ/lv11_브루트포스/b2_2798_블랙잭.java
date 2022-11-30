package lv11_브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b2_2798_블랙잭 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // 카드 개수
		int M = Integer.parseInt(st.nextToken()); // M에 가까운 수
		int sum = 0; // 세 수의 합
		int result = 0; // M과 가까운 값
		int num[] = new int[N]; // 세 수를 넣을 배열
		
		st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 0; i<N; i++) {
			num[i] = Integer.parseInt(st.nextToken()); // 숫자 하나씩 넣기
		} 
		
		for(int i = 0; i < N-2; i++) {
			for(int j = i+1; j < N-1; j++) {
				for(int k=j+1; k < N; k++) {
					sum = num[i] + num[j] + num[k]; //세 수의 값 sum
					if(result < sum && sum <= M) { //M보다 작은 sum 중에 가장 큰 sum 뽑기
						result = sum;
					}
				}
			}
		}
		System.out.println(result);
	}
}
