package A형기출문제;

import java.io.*;
import java.util.*;

/*
 * 입력
 * 1. 10X10 종이
 * 출력
 * 1. 모든 1을 덮는 데 필요한 색종이의 최소 개수
 * 2. 모두 덮는 것이 불가능한 경우에는 -1
 * 조건
 * 1. 색종이는 다섯 개씩 가지고 있음
 * 2. 1x1부터 5x5까지
 * 3. 0이 있는 칸에는 색종이가 붙으면 안 됨
 * 
 * >> 5개부터 보기...?? 시간초과 날것 같기는 함
 */
public class g2_17136_색종이붙이기 {
	static int len, max, countOne, min;
	static int[][] paper;
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		paper = new int[10][10];
		
		for (int i = 0; i < 10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
				if(paper[i][j] == 1) {
					len++;
					countOne++;
				}
				else len = 0;
				max = Math.max(max, len);
			}
		}
		
		max = Math.max(max, 5);
		
		dfs(0, 0, 0);
		
		System.out.println(min);

	}


	private static void dfs(int x, int y, int cnt) {
		if(countOne == 0) {
			min = Math.min(min, cnt); 
		}
		if(paper[x][y]==1) {
			for(int len = max; len>=1; len--) {
				if(x<0 || x>=10 || y<0 || y>=0 || paper[x][y] == 0) continue;
				for(int i = x; i<x+len; i++) {
					for(int j = y; j<y+len; j++) {
						paper[i][j] = 0;
						countOne--;
						dfs(i, j, cnt+1);
					}
				}
				
				
				
			}
		}
		
	}

}
