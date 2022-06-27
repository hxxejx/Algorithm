package com.ssafy.im;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 1. 테스트 케이스 개수 T
 * 2. 재료의 수 N 제한 칼로리 L
 * 3. 재료 점수 Ti 재료 칼로리 Ki
 * 4. 칼로리 이하의 점수 중 재료 점수가 제일 높은 것을 찾자
 * 
 * >> 브루트포스로 해야 함.. 비슷한 걸 풀어봤었는데 기억이 안 나네 >> 블랙잭
 * >> 이하 칼로리가 나올 수 있는 경우의 수를 모두 풀고 가장 높은 점수를 찾아야 함!!
 * >> 어제 푼 dfs로 가능한가?? XX
 * >> 모두 더한다... 칼로리가 낮을 때까지 근데 배열을 바꿔가면서 더한다
 *  	>> 재귀로 풀어야 할듯 ㅜ
 * >> 칼로리가 넘으면 값을 더하고 리턴.. 근데 그게 최대값이면 result에 저장
 * >> 부분집합으로 풀기!!!!!!!!
 */
public class D3_5215_햄버거다이어트 { 
	
	static int N; //재료의 수
	static int L; //제한 칼로리
	static int[] Ti; //점수
	static int[] Ki; //칼로리
	static int[][] mat;
	static int result;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		File file = new File("D3_5215_햄버거다이어트.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine()); //테스트 케이스
		
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			mat = new int[N][2];
			//Ti = new int[N];
			//Ki = new int[N];
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				//Ti[i] = Integer.parseInt(st.nextToken());
				//Ki[i] = Integer.parseInt(st.nextToken());
				//이렇게 했더니 오류 뜸ㅜㅜ 검색해서 배열로 넣음
				mat[i][0] = Integer.parseInt(st.nextToken());
				mat[i][1] = Integer.parseInt(st.nextToken());
			} // 배열에 넣기
			
			result = 0;			
			kcal(0, 0, 0);
			
			System.out.println("#" + tc + " " + result);
			
		} // tc
	} // main

    public static void kcal(int idx, int scr, int cal) {

        if (cal > L) return;
        if (cal <= L) result = Math.max(result, scr);
        if (idx == N) return;
        
        kcal(idx + 1, scr + mat[idx][0], cal + mat[idx][1]);
        //kcal(idx + 1, scr + Ti[idx], cal + Ki[idx]);
        kcal(idx + 1, scr, cal);
    }
 
} // class
