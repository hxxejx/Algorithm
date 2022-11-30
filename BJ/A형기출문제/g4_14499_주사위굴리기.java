package A형기출문제;

import java.io.*;
import java.util.*;

import com.sun.org.apache.xml.internal.serializer.utils.StringToIntTable;

/*
 * 입력
 * 1. 지도의 세로 N 가로 M 좌표 x, y 명령의 개수 K
 * 2. 지도에 쓰여 있는 수 주사위는 0
 * 3. 이동하는 명령 동1 서2 북3 남4
 * 출력
 * 1. 주사위의 윗면에 쓰여 있는 수 출력
 * 2. 바깥으로 이동시키려고 하는 경우 해당 명령 무시
 * 조건
 * 1. 
 */
public class g4_14499_주사위굴리기 {
	static int N, M, K, map[][];
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[] dx = {0, 0, -1, 1};
		int[] dy = {1, -1, 0, 0};
		int[][] d = {{3, 4, 2, 5}, {3, 4, 6, 1}, {6, 1, 2, 5}, {1, 6, 2, 5}, {3, 4, 1, 6}, {3, 4, 5, 2}};
		
		st = new StringTokenizer(br.readLine());
		for (int k = 0; k < K; k++) {
			int command = Integer.parseInt(st.nextToken()) - 1;
			
			int i = x + dx[command];
			int j = y + dy[command];
			
			if(i<0 || i>=N || j<0 || j>=M) continue;
			
			sb.append("주사위 윗면").append("\n");
		}
		
		System.out.println(sb);
		System.exit(0);

	}


}
