package com.ssafy.boj;

import java.io.*;
import java.util.*;

/*
 * 입력
 * 1. 테스트 케이스 t
 * 2. 편의점의 개수 n
 * 3. 상근이네 집, 편의점, 펜타포트 락 페스티벌 좌표
 * 출력
 * 1. 행복하면 happy 이동할 수 없으면 sad
 * 조건
 * 1. 50m에 한 병씩 마셔야 한다
 * 2. 20개를 들고 다닐 수 있다
 * 3. 편의점에서 빈 병을 버리고 새 맥주 병을 살 수 있다
 */
public class BJ_9205_맥주마시면서걸어가기_허은지 {
	static int n, arr[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc<t; tc++) {
			n = Integer.parseInt(br.readLine());
			
			arr = new int[n+2][n+2];
			int[][] point = new int[n+2][2];
			
			for(int i = 0; i<n+2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				point[i][0] = Integer.parseInt(st.nextToken());
				point[i][1] = Integer.parseInt(st.nextToken());
			}
			
			for(int i = 0; i<n+1; i++) {
				for(int j = i+1; j<n+2; j++) {
					if(Math.abs(point[i][0]-point[j][0])+ Math.abs(point[i][1]-point[j][1]) <= 1000) {
						arr[i][j] = arr[j][i] = 1;
						
					}
				}		
			}
			
			if(bfs()) sb.append("happy\n");
			else sb.append("sad\n");

		}

		System.out.println(sb);
		
	}
	private static boolean bfs() {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[n + 2];
		
		visited[0] = true;
		queue.offer(0);
		
		while(!queue.isEmpty()) {
			int index = queue.poll();
			
			for(int i = 1; i < n + 2; i++) {
				if(arr[index][i]==1) {
					if(i == n + 1) return true;

					if(!visited[i]) {
						visited[i] = true;
						queue.offer(i);
					}
				}
			}
		}
		
		return false;
	}

}
