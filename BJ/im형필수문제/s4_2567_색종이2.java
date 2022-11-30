package im형필수문제;

import java.util.*;
import java.io.*;

/*
 * 입력
 * 1. 색종이의 수 N
 * 2. 색종이를 붙일 위치 x y (왼쪽 아래 좌표, 크기는 10)
 * 출력
 * 색종이가 붙은 영역의 둘레
 * 
 * >> 1인 부분만 골라 사방 탐색 해서 한쪽이 0이 있으면 +1
 */
public class s4_2567_색종이2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		int[][] arr = new int[101][101];
		
		int N = Integer.parseInt(br.readLine());
		int len = 0;
		
		for(int n = 0; n < N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			for(int i = x; i < 10+x; i++) { //x와 y 좌표로부터 10만큼 색종이 붙이기
				for(int j = y; j < 10+y; j++) {
					arr[i][j] = 1;
				}
			}
		} // 색종이 붙이기
		
		for(int i = 0; i < 101; i++) {
			for(int j = 0; j < 101; j++) {
				if(arr[i][j]==1) { // 색종이가 붙은 부분 탐색
					for(int k = 0; k < 4; k++) {
						int x = i+dx[k];
						int y = j+dy[k];
						if(arr[x][y]==0) len++; // 사방탐색 중 0인 부분이 있으면 둘레로 계산
					}
				}
			}
		} // 둘레 구하기
		
		System.out.println(len);
	}
}
