package com.ssafy.im;

import java.util.*;
import java.io.*;

/*
 * 입력
 * 1. 테스트 케이스 T
 * 2. 총 이동 시간 M 배터리의 개수 BC
 * 3. A의 이동 정보
 * 4. B의 이동 정보
 * 5. 배터리의 정보 좌표 x 좌표 y 충전 범위 C 처리량 P
 * 출력
 * "#" + tc + " " + result
 * 
 * >> arr[10][10] 배열에 P 채우기 >> BC 번호 채우기 겹치는 부분은 P가 더 작은 값을 *10 해서 두 자리 수로 만들기
 * >> 겹치는 부분을 어떻게 해야 하지?
 */
public class im_5644_무선충전_허은지 {

	static int M, BC;
	static int[][] map;
	static Queue<Integer> A, B;
	static int x, y, C;
	static int[] P;
	static int[] dx = {-1, 0, 1, 0}; //상우하좌
	static int[] dy = {0, 1, 0, -1};
	public static void main(String[] args) throws Exception {
		File file = new File("im_5644_무선충전.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			BC = Integer.parseInt(st.nextToken());
			
			map = new int[10][10];
			P = new int[BC];
		
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < M; i++) {
				A.add(Integer.parseInt(st.nextToken()));
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < M; i++) {
				B.add(Integer.parseInt(st.nextToken()));
			}
			
			for(int i = 1; i <= BC; i++) {
				st = new StringTokenizer(br.readLine());
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				C = Integer.parseInt(st.nextToken());
				P[i] = Integer.parseInt(st.nextToken());
				
				//bcMap(0,0,i);
				
				for(int j = 0; j<=C; j++) {
					for(int k = 0; k<=C-j; k++) {
						
						if(x+k<10 && y+j<10) {
							if(map[x+k][y+j]!=0) setNum(x+k, y+j, i);
							else map[x+k][y+j] = i;
						}
						if(x-k>=0 && y+j<10) {
							if(map[x-k][y+j]!=0) setNum(x-k, y+j, i);
							else map[x-k][y+j] = i;
						}
						if(x+k<10 && y-j>=0) {
							if(map[x+k][y-j]!=0) setNum(x+k, y-j, i);
							else map[x+k][y-j] = i;
						}
						if(x-k>=0 && y-j>=0) {
							if(map[x-k][y-j]!=0) setNum(x-k, y-j, i);
							else map[x-k][y-j] = i;
						}
					}
				} //배터리 번호 넣기
			} //배터리 맵에 넣기
			
			for(int i = 0; i<M; i++) {
				int goA = A.poll();
				int goB = B.poll();
				
				
				
//				go();
			}
			
		}
		
	}//main
//	private static void go() {
//		
//		
//		for(int k = 0; k<M; k++) {
//			int nx = i + dx[k];
//			int ny = j + dy[k];
//			if(nx < 0 || nx >= N || ny < 0 || ny >= N) { //배열을 벗어나면 continue
//				continue;
//			}
//			if(map[nx][ny] == map[i][j] + 1) { //1을 더한 값을 찾았을 때
//				plus1(nx, ny); //그곳에서 다시 plus1 함수 호출
//				count[i][j] = Math.max(count[i][j], count[nx][ny]+1); //결과값 큰 것 구하기
//			}
//		}
//		switch(A.poll()) {
//		case 0:
//			
//			break;
//		case 1:
//			k=1;
//			break;
//		case 2:
//			
//			break;
//		case 3:
//			
//			break;
//		case 4:
//			
//			break;
//		}
//		
//	}
	private static void setNum(int i, int j, int bcNum) {
		if(map[i][j]!=0) {
			int max = Math.max(P[bcNum] , P[map[i][j]]);
			int min = Math.min(P[bcNum] , P[map[i][j]]);
			int num = min*10 + max;
			map[i][j] = num;
		}
	}
	
	
	
//	private static void bcMap(int dx, int dy, int bcNum) {
//		int dx=0;
//		int dy=0;
//		if(dx==0 || dy==0) return;
//		if(map[x+dx][y+dy]!=0) {
//			int max = Math.max(P[bcNum] , P[map[dx][dy]]);
//			int min = Math.min(P[bcNum] , P[map[dx][dy]]);
//			int num = min*10 + max;
//			map[dx][dy] = num;
//		}
//		for(int i = 0; i<C; i++) {
//			if(x+dx<10 && y+dy<10) map[x+dx][y+dy] = i;
//			if(x-dx>=0 && y+dy<10) map[x-dx][y+dy] = i;
//		}
//		
//	}
	
	

}//class
