package boj_미완;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s5_1018_체스판다시칠하기 {
	static char chess[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // 행 N
		int M = Integer.parseInt(st.nextToken()); // 열 M
		char[][] chess = new char[N][M];
		
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				chess[i][j] = s.charAt(j);
			}
		}
		
		int ans = 1000000;

		for (int i = 0; i < N-7; i++) { //최소 크기가 8일때 경우의 수가 1 - 7을 빼는것이 경우의 수
			for (int j = 0; j < M-7; j++) {
				int B = 0; //B부터 시작
				int W = 0; //W부터 시작
				for (int x = i; x < i+8; x++) { //x좌표의 끝 +8
					for (int y = j; y < j+8; y++) {
						if((x + y) % 2 == 0) { //칸 설정
							if(chess[x][y] == 'B') W++; // B일 때 W 추가
							else B++; // 아니면 B 추가
						}else { // (i + j) % 2 == 1) 다른 칸일 때 반대의 경우
							if(chess[x][y] == 'W') W++;
							else B++;
						}
					}
				}
				ans = Math.min(ans, Math.min(B,W)); // B로 시작하는 것과 W로 시작하는 것 중 더 적은 값 출력
				//    ㄴfor문 돌 동안 가장 작은 값 찾기
			}
		}
		System.out.println(ans);
	}
}

