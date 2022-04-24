package 플로이드와샬;

import java.io.*;
import java.util.*;

/*
 * 입력
 * 1. 테스트 케이스 T
 * 2. 학생들의 수 N
 * 3. 학생의 키를 비교한 횟수 M
 * 4. 학생의 키를 비교한 결과 a, b >> a가 b보다 키가 작음
 * 출력
 * 1. #tc 자신이 키가 몇번째인지 알 수 있는 학생이 모두 몇 명인지
 * 
 * >> 플로이드-워샬 사용
 */
public class g4_2458_키순서 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
			
        int[][] arr = new int[N][N];
	        
        int max = N*(N*(N-1)/2); //최댓값
	        
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                arr[i][j] = max; 
            }
        }
	        
        for(int i = 0; i < M; i++) {
        	st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            arr[n1 - 1][n2 - 1] = 1;
        }
	        
        for(int k = 0; k < N; k++) { // 경유지
            for(int i = 0; i < N; i++) { // 출발지
                for(int j = 0; j < N; j++) { // 도착지
                    if(arr[i][j] > arr[i][k] + arr[k][j]) {
                        arr[i][j] = arr[i][k] + arr[k][j];
                    }
                }
            }
        }
	        
        int ans = 0;
        for(int i = 0; i < N; i++) {
            int count = 0;
            for(int j = 0; j < N; j++) {
                if(arr[i][j] < max || arr[j][i] < max) count++;
            }
            if(count == N-1) ans++;
        }
	        
		
		System.out.println(ans);
	}
}
