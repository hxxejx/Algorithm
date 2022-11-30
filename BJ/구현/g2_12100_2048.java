package 구현;

import java.io.*;
import java.util.*;

/*
 * 입력
 * 1. 보드의 크기 N
 * 2. 초기 상태
 * 출력
 * 1. 최대 5번 이동시켜서 얻을 수 있는 가장 큰 블록
 */
public class g2_12100_2048 {
	static int N, arr[][], max;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		max = Integer.MIN_VALUE;
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		game(0);
		
		System.out.println(max);
		
	}

	private static void game(int cnt) {
		if(cnt==5) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					max = Math.max(max, arr[i][j]);
				}
			}
			
			return;
		}
		
		int[][] tmp = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			tmp[i] = arr[i].clone();
		}
		
		for (int k = 0; k < 4; k++) {
			switch (k) {
			// 위
			case 0:
				for (int i = 0; i < N; i++) {
					int index = 0;
					int block = 0;
					for (int j = 0; j < N; j++) {
						if (arr[j][i] != 0) {
							if (block == arr[j][i]) {
								arr[index - 1][i] = block * 2;
								block = 0;
								arr[j][i] = 0;
							} else {
								block = arr[j][i];
								arr[j][i] = 0;
								arr[index][i] = block;
								index++;
							}
						}
					}
				}
				break;
			// 아래
			case 1:
				for (int i = 0; i < N; i++) {
					int index = N - 1;
					int block = 0;
					for (int j = N - 1; j >= 0; j--) {
						if (arr[j][i] != 0) {
							if (block == arr[j][i]) {
								arr[index + 1][i] = block * 2;
								block = 0;
								arr[j][i] = 0;
							} else {
								block = arr[j][i];
								arr[j][i] = 0;
								arr[index][i] = block;
								index--;
							}
						}
					}
				}
				break;
			// 왼쪽
			case 2:
				for (int i = 0; i < N; i++) {
					int index = 0;
					int block = 0;
					for (int j = 0; j < N; j++) {
						if (arr[i][j] != 0) {
							if (block == arr[i][j]) {
								arr[i][index - 1] = block * 2;
								block = 0;
								arr[i][j] = 0;
							} else {
								block = arr[i][j];
								arr[i][j] = 0;
								arr[i][index] = block;
								index++;
							}
						}
					}
				}
				break;
			// 오른쪽
			case 3:
				for (int i = 0; i < N; i++) {
					int index = N - 1;
					int block = 0;
					for (int j = N - 1; j >= 0; j--) {
						if (arr[i][j] != 0) {
							if (arr[i][j] == block) {
								arr[i][index + 1] = block * 2;
								block = 0;
								arr[i][j] = 0;
							} else {
								block = arr[i][j];
								arr[i][j] = 0;
								arr[i][index] = block;
								index--;
							}
						}
					}
				}
				break;
			}

			game(cnt+1);
			
			for (int i = 0; i < N; i++) {
				arr[i] = tmp[i].clone();
			}
		}
		
	}

}
