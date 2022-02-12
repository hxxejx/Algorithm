package im형필수문제;

import java.io.*;
import java.util.*;

/*
 * 1. 사각형은 네 개
 * 2. 왼쪽 아래 꼭짓점의 x, y 오른쪽 위 꼭짓점의 x, y
 * 3. arr[101][101]
 * 4. 출력: 네 개의 직사각형이 차지하는 면적
 */
public class b1_2669_직사각형네개의합집합의면적구하기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] arr = new int[101][101];
		int result = 0;
		
		for(int n = 0; n<4; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			for(int i = x1; i<x2; i++) {
				for(int j = y1; j<y2; j++) {
					arr[i][j] = 1;
				}
			}
		}
		
		for(int i = 0; i<101; i++) {
			for(int j = 0; j<101; j++) {
				if(arr[i][j]==1) result++;
			}
		}
		System.out.println(result);
	}
}
