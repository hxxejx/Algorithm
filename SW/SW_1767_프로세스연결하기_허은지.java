package com.ssafy.im;

import java.io.*;
import java.util.*;

public class SW_1767_프로세스연결하기_허은지 {
	static int T, N, size, min;
	static int[][] arr;
	static boolean[][] checked;
	static List<int[]> core;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			core = new ArrayList<int[]>();
			checked = new boolean[N][N];
			
			size = 0;
			min = Integer.MAX_VALUE;
			
			for(int i = 0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j<N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i = 1; i<N-1; i++) {
				for(int j = 1; j<N-1; j++) {
					if(arr[i][j]==1) core.add(new int[] {i, j});
				}
			}
			
			for(int i = 0; i<4; i++) {
				check(core.get(0)[0], core.get(0)[1], i, 0, 0, 0);
			}
			
			sb.append("#").append(tc).append(" ").append(min);
			
		}
		
		System.out.println(sb);

	}
	
	private static void check(int x, int y, int dir, int start, int cnt, int tmp) {
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};

		if(x==0 || x==N-1 || y==0 || y==N-1) { //전선 연결 끝
			if(start+1==core.size()) {
				if(tmp>=size) {
					if(tmp>size) {
						size=tmp;
						min=cnt;
					}
					else if(min>cnt) {
						min=cnt;
					}
					return;
				}
			}else {
				int ty=core.get(start+1)[0];
				int tx=core.get(start+1)[1];
				for(int k=0;k<4;k++) {
					check(ty,tx,k,start+1,cnt,tmp+1);
				}
			}
		
			return;
		}
		
		int r=x+dx[dir];
		int c=y+dy[dir];

		if(checked[r][c] || arr[r][c]==1) {
			if(start+1==core.size()) return;
			r=core.get(start+1)[0];
			c=core.get(start+1)[1];
			for(int k=0;k<4;k++) {
				check(r, c, k, start+1, cnt, tmp);
			}
			return;
		}
			
		checked[r][c]=true;
		check(r, c, dir, start, cnt+1, tmp);
		checked[r][c]=false;
	}

}
