package boj_미완;

import java.util.*;
import java.io.*;

/*
 * 입력
 * 1. 짝수 N
 * 2. N개의 줄에 S
 * 3. Sii는 항상 0
 * 출력
 * 스타트 팀과 링크 팀의 능력치의 차이의 최솟값
 * 
 * >> 요리 문제랑 똑같음
 * >> 순열 사용해서 더하기
 */
public class s2_14889_스타트와링크 {
	static int N, R, ans;
	static int[][] ability;
//	static int[] team, startTeam;
	static boolean[] isSelected;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		R = N/2;
		
		ability = new int[N][N];
		isSelected = new boolean[N];
//		team = new int[N];
//		startTeam = new int[R];
		ans = Integer.MAX_VALUE;
		
		for(int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j<N; j++) {
				ability[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
//		for(int i = 0; i<N; i++){
//			team[i] = i+1;
//		}
		
		select(0);
		
		System.out.println(ans);

	}
	private static void select(int cnt) {
		int start = 0;
		int link = 0;
		if(cnt==R) {
			for(int i = 0; i<N-1; i++) {
				for(int j = i+1; j<N; j++) {
					if(isSelected[i]==true && isSelected[j]==true) start += ability[i][j] + ability[j][i];
					else if(isSelected[i]==false && isSelected[j]==false) link += ability[i][j] + ability[j][i];
				}
			}
			//System.out.println(Math.abs(start-link));
			int val = Math.abs(start-link);
			if(val==0) {
				System.out.println(val);
				System.exit(0);
			}
			
			ans = Math.min(ans, val);
			return;
		}
		for(int i = 0; i<N; i++) {
			if(isSelected[i]) continue;
//			startTeam[cnt] = team[i];
			isSelected[i] = true;
			select(cnt+1);
			isSelected[i] = false;
		}
		
	}

}
