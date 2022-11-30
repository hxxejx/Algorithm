package im형필수문제;

import java.util.*;
import java.io.*;

/*
 * 입력
 * 1. 보드의 크기 N
 * 2. 보드에 채워져 있는 사탕의 색상 C P Z Y
 * 출력
 * 가장 많이 먹을 수 있는 사탕 개수
 * 
 * >> 애니팡
 * >> 다른점: 자리를 바꾸지 않아도 가장 긴 것을 고르면 먹을 수 있음
 * >> 색이 다른 칸만 자리를 바꿀 수 있음
 * 
 * >> 인접한 사탕의 색이 다르면 자리 바꾸기
 * >> 자리 바꾼 뒤 가장 긴 연속 부분 구하기
 * >> 최댓값 구하기
 */
public class s3_3085_사탕게임 {
	static int N, cnt, max;
	static char[][] arr;
	static int[] dx = {1, 0}; //하우
	static int[] dy = {0, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new char[N][N];
		max = Integer.MIN_VALUE;
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			arr[i] = str.toCharArray();
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				for(int k = 0; k < 2; k++) {
					cnt = 1;
					char color = arr[i][j];
					int x = i;
					int y = j;
					//System.out.println(arr[x][y]);
					while(true) {
						x += dx[k];
						y += dy[k];
						if(x<0 || x>=N || y<0 || y>=N || arr[x][y]!= color) {
							max = Math.max(max, cnt);
							break;
						}
						cnt++;
					}
					max = Math.max(max, cnt);
				}
			}
		} //옮기기 전 최대 개수 구하기
		//System.out.println("원래 배열 max값: " + max);
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				for(int k = 0; k < 2; k++) {
					int x = i + dx[k];
					int y = j + dy[k];
					
					if(x<0 || x>=N || y<0 || y>=N) continue; //배열 벗어나면 continue;
					
					char tmp = arr[i][j];
					arr[i][j] = arr[x][y];
					arr[x][y] = tmp;
					
					//candy();
					
					char color = arr[x][y];
					for(int l = 0; l < 2; l++) {
						cnt = 1;
						while(true) {
							x += dx[l];
							y += dy[l];
							if(x<0 || x>=N || y<0 || y>=N || arr[x][y]!= color) {
								max = Math.max(max, cnt);
								break;
							}
							cnt++;
						}
						max = Math.max(max, cnt);
						//System.out.println(max);
					}
					
					color = arr[i][j];
					for(int l = 0; l < 2; l++) {
						cnt = 1;
						while(true) {
							x += dx[l];
							y += dy[l];
							if(x<0 || x>=N || y<0 || y>=N || arr[x][y]!= color) {
								max = Math.max(max, cnt);
								break;
							}
							cnt++;
						}
						max = Math.max(max, cnt);
						//System.out.println(max);
					}
					
					tmp = arr[i][j];
					arr[i][j] = arr[x][y];
					arr[x][y] = tmp;
					
					//candy(0,0); //캔디 최대 개수 세기
					
				}
				
			}
		}
		
		System.out.println(max);

	}

//	private static void candy() {
//		for(int i = 0; i < N; i++) {
//			for(int j = 0; j < N; j++) {
//				for(int k = 0; k < 2; k++) {
//					cnt = 1;
//					char color = arr[i][j];
//					int x = i;
//					int y = j;
//					//System.out.println(arr[x][y]);
//					while(true) {
//						x += dx[k];
//						y += dy[k];
//						if(x<0 || x>=N || y<0 || y>=N || arr[x][y]!= color) {
//							max = Math.max(max, cnt);
//							break;
//						}
//						cnt++;
//					}
//					max = Math.max(max, cnt);
//				}
//			}
//		}
//	}

}
