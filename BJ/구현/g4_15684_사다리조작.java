package 구현;

import java.io.*;
import java.util.*;

/*
 * 입력
 * 1. 세로선의 개수 N 가로 선의 개수 M 가로선을 놓을 수 있는 위치의 개수 H
 * 2. 가로선의 정보 a b
 * 출력
 * 1. i번 세로선의 결과가 i번이 나오기 위해 추가해야 하는 가로선 개수의 최솟값
 * 2. 3보다 크거나 불가능할 경우 -1 출력
 * 
 * >> 괄호의 개수 구하는 것처럼 구하기
 * >> 무조건 한 줄에 짝수개 있어야 됨
 */
public class g4_15684_사다리조작 {
	static int N, M, H, ladder[][];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		if(M==0) {
			System.out.println(0);
			System.exit(0);
		}
		
		ladder = new int[H][N];
		boolean[] line = new boolean[N];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			
			ladder[a][b] = 1;
			line[b] = !line[b];
			
			if(a-1>=0) ladder[a-1][b] = -1;
			if(a+1<N) ladder[a+1][b] = -1;
		}
		
		for (int i = 0; i < N; i++) {
			go(i);
		}

	}

	private static void go(int i) {
		
		
	}

}
