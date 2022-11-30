package lv11_브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s5_7568_덩치 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 사람 수 N
		int[][] info = new int[N][2]; // 키, 몸무게 두 개
		
		StringTokenizer st;
		
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			info[i][0] = Integer.parseInt(st.nextToken()); // 몸무게
			info[i][1] = Integer.parseInt(st.nextToken()); // 키
		} 
		
		for(int i = 0; i<N; i++) {
			int rank = 0;
			for(int j = 0; j < N; j++) {
				if(info[i][0] < info[j][0] && info[i][1] < info[j][1]) { // 몸무게, 키 둘 다 작으면
					rank++; //순위 내려감(숫자는 올라감)
				}
			}
			System.out.print((rank+1) + " ");
		}		
	}
}
