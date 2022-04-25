import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		// 숫자의 사전 순서
		int[] dic = {8,5,4,9,1,7,6,3,2,0};
		
		// 줄바꿈을 위한 변수
		int cnt = 0;
		
		// 배열의 크기만큼 for문 돌리기
		for(int i = 0; i<10; i++) {
			// 1~9 출력
			// dic[i]이 M보다 크거나 같고 N보다 작거나 같다면 출력 저장
			if(dic[i]>=M && dic[i]<=N) {
				sb.append(dic[i]).append(" ");
				
				// 10개마다 엔터 치기
				if(++cnt%10 == 0) sb.append("\n");
			}
			
			// 11~99 출력
			// dic[i]를 십의자리로 가진 숫자
			
			// dic[i] = 5라고 했을 때,
			// M이 48이라면 48, 49도 계산해야 하기 때문에 M-10
			if(dic[i]*10>=M-10) {
				// 일의자리 구하기
				for(int k = 0; k < 10; k++) {
					// dic[i]를 십의자리로 가지고 dic[k]를 일의자리로 가진 숫자 구하기
					int num = dic[i]*10 + dic[k];
					// num이 10보다 작거나(위에서 이미 구함)
					// num이 M 이상 N 이하의 조건에서 벗어날 경우 continue
					if(num < 10 || num<M || num>N) continue;
					
					// 조건을 만족하면 출력 저장
					sb.append(num).append(" ");
					
					// 10개마다 엔터 치기
					if(++cnt%10 == 0) sb.append("\n");
				}
			}
		}
		
		// 출력하기
		System.out.println(sb);

	}

}
