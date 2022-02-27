package com.ssafy.im;

import java.io.*;
import java.util.*;

/*
 * 입력
 * 1. 테스트 케이스 T
 * 2. 맵의 높이 H 너비 W
 * 3. H의 줄에 맵 문자열
 * 4. 정수 N
 * 5. 길이가 N인 문자열(위아래왼쪽오른쪽 UDLR 포탄 S)
 * 출력
 * 1. #tc 게임 맵
 * 조건
.	평지(전차가 들어갈 수 있다.)
*	벽돌로 만들어진 벽
#	강철로 만들어진 벽
-	물(전차는 들어갈 수 없다.)
^	위쪽을 바라보는 전차(아래는 평지이다.)
v	아래쪽을 바라보는 전차(아래는 평지이다.)
<	왼쪽을 바라보는 전차(아래는 평지이다.)
>	오른쪽을 바라보는 전차(아래는 평지이다.)
 */
public class D3_1873_상호의배틀필드 {
	static int x, y, H, W;
	static char[][] arr;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			
			arr = new char[H][W];
			
			for(int i = 0; i<H; i++) {
				String str = br.readLine();
				for(int j = 0; j<W; j++) {
					arr[i][j] = str.charAt(j);
					//초기 전차 위치
					if(arr[i][j]=='<' || arr[i][j]=='>' || arr[i][j]=='^' || arr[i][j]=='v') {
						x = i;
						y = j;
					}
				}
			}
			
			int N = Integer.parseInt(br.readLine());
			String str = br.readLine();
			for(int i = 0; i<N; i++) {
				char cmd = str.charAt(i);
				switch(cmd) {
				case 'S':
					//전차가 바라보는 방향에 따라 바뀜
					switch(arr[x][y]) {
					case '^':
						shoot(0);
						break;
					case 'v':
						shoot(1);
						break;
					case '<':
						shoot(2);
						break;
					case '>':
						shoot(3);
						break;
					}
					break;
				case 'U':
					go(0);
					break;
				case 'D':
					go(1);
					break;
				case 'L':
					go(2);
					break;
				case 'R':
					go(3);
					break;
				}
			}
			
			sb.append("#").append(tc).append(" ");
			
			for(int i = 0; i<H; i++) {
				for(int j = 0; j<W; j++) {
					sb.append(arr[i][j]);
				}
				sb.append("\n");
			}
			
		}
		
		System.out.println(sb);
		
	}

	private static void shoot(int i) {		
		int r = x;
		int c = y;
		
		//배열을 벗어나거나, 벽을 만나기 전까지 반복
		while(true) {
			r += dx[i];
			c += dy[i];
			//배열을 벗어나면 break
			if(r<0 || r>=H || c<0 || c>=W) break;
			//벽돌로 만든 벽이 나오면 평지로 바꾼다
			if(arr[r][c]=='*') {
				arr[r][c] = '.';
				break;
			//강철로 만들어진 벽이 나오면 부수지 못하고 break
			} else if(arr[r][c]=='#') break;
		}
		
	}

	private static void go(int i) {
		char[] tank = {'^', 'v', '<', '>'};

		int r = x + dx[i];
		int c = y + dy[i];
		//배열을 벗어나지 않고, 평지라면 이동
		if(r>=0 && r<H && c>=0 && c<W && arr[r][c]=='.') {
			//원래 있던 곳은 평지로 바꿈
			arr[x][y] = '.';
			//평지로 전차 이동시켜 줌
			arr[r][c] = tank[i];
			x = r;
			y = c;
		} else {
			//아니라면 전차 제자리
			arr[x][y] = tank[i];
		}
		
	}

}
