package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 1. 배열의 크기 N M 수행해야 하는 연산의 수 R
 * 2. N개의 줄에 배열 A의 원소
 * 3. 수행해야 하는 연산
 * 
 *  >> 1. 상하반전
 *  >> 2. 좌우반전
 *  >> 3. 오른쪽으로 90도 회전
 *  >> 4. 왼쪽으로 90도 회전
 *  >> 5. 네등분해서 시계방향으로 보내기
 *  >> 6. 네등분해서 시계반대방향으로 보내기
 */

public class S2_16935_배열돌리기3 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[N][M];
		int[][] result = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		} // arr 만들기
		
		st = new StringTokenizer(br.readLine());
		for(int rc=0; rc<R; rc++) { //연산 수만큼 반복
			int num = Integer.parseInt(st.nextToken());
			
			switch(num){
			case 1:
				for(int i = 0; i < N; i++) {
					for(int j = 0; j < M; j++) {
						result[i][j] = arr[N-i-1][j];
					}
				}
				arr = result;
				break;
			case 2:
				for(int i = 0; i < N; i++) {
					for(int j = 0; j < M; j++) {
						result[i][j] = arr[i][M-j-1];
					}
				}
				arr = result;
				break;
			case 3:
				result = new int[M][N];
				for(int i = 0; i < N; i++) {
					for(int j = 0; j < M; j++) {
						result[j][N-i-1] = arr[i][j];
					}
				}
				
				int tmp = N;
				N = M;
				M = tmp;
				
				arr = result;
				break;
			case 4:
				result = new int[M][N];
				for(int i = 0; i < N; i++) {
					for(int j = 0; j < M; j++) {
						result[M-j-1][i] = arr[i][j];
					}
				}
				
				tmp = N;
				N = M;
				M = tmp;
				
				arr = result;
				break;
			case 5:
				int x = N/2;
				for(int i = 0; i < N; i++) {
					for(int j = 0; j < M/2; j++) {
						result[i][j] = arr[x][j];
					}
					x -= (N/2)*(int)Math.pow(-1, i);
					for(int j = 0; j < M/2; j++) {
						result[i][j+M/2] = arr[x][j];
					}
					if(i%2==1) x++;
				}
				x = N/2;
				for(int i = 0; i < N; i++) {
					for(int j = M/2; j < M; j++) {
						result[i+M/2][j] = arr[x][j];
					}
					x -= (N/2)*(int)Math.pow(-1, i);
					for(int j = M/2; j < M; j++) {
						result[i+M/2][j] = arr[x][j];
					}
					if(i%2==1) x++;
				}
				arr = result;
				break;
			case 6:
				x = 0;
				for(int i = 0; i < N; i++) {
					for(int j = M/2; j < M; j++) {
						result[i][j] = arr[x][j];
					}
					x -= (N/2)*(int)Math.pow(-1, i+1);
					if(i%2==1) x++;
				}
				x = 0;
				for(int i = 0; i < N; i++) {
					for(int j = 0; j < M/2; j++) {
						result[i][j] = arr[x][j];
					}
					x -= (N/2)*(int)Math.pow(-1, i+1);
					if(i%2==1) x++;
				}
				arr = result;
				break;
			} // switch
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
		} // for
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	} // main
} // class