package com.ssafy.im;

import java.util.*;
import java.io.*;

/*
 * 입력
 * 1. 입력받는 데이터의 길이와 시작점
 * 2. from, to ...
 * 출력
 * "#" + tc + " " + ans
 * 
 * >> BFS 너비 우선 탐색
 * >> 마지막에 연락받은 사람들 중 가장 숫자가 큰 사람 출력
 */
public class D4_1238_Contact {
	static int N, max, ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("D4_1238_Contact.txt"));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int tc = 0;
		
		while(true) {
			//System.out.println("---------------------" + (tc+1) + "----------------------");
			ans = 0;
			max = 0;
			String str = br.readLine();
			if(str==null) break;
			StringTokenizer st = new StringTokenizer(str);
			N = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			
			int[][] arr = new int[101][101];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i<N/2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				arr[from][to] = 1;
			}
			
			//dfs(arr,new boolean[101],V,0);
			bfs(arr,new int[101],V,0);
			
			sb.append("#").append(++tc).append(" ").append(ans).append("\n");
		}
		
		System.out.println(sb);
	}

	private static void dfs(int[][] arr, boolean[] visited, int start, int cnt) {
		System.out.println(cnt + " " +start);
		if(cnt>max) {
			ans = start;
			max = cnt;
		} else if(cnt==max && start > ans) {
			ans = start;
		}
		for(int i = 0; i<101; i++) {
			visited[start] = true;
			if(!visited[i] && arr[start][i]==1) {
				dfs(arr, visited, i, cnt+1);
			}
			
		}
		cnt--;
	}
	
	private static void bfs(int[][] arr, int[] visited, int start, int cnt) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		visited[start] = 1;
		
		while(!queue.isEmpty()) {
			start = queue.poll();
//			cnt++;
			for(int i = 0; i<101; i++) {
				if(visited[i]==0 && arr[start][i]==1) {
					queue.add(i);
					visited[i] = visited[start]+1;
					//System.out.println(cnt + " " +i);
					
					
//					if(cnt>max) {
//						ans = i;
//						max = cnt;
//					} else if(cnt==max && i > ans) {
//						ans = i;
//					}
				}
				
			}
		}
		
		for(int i = 1; i<101; i++) {
			if(max<=visited[i]) {
				max = visited[i];
				ans = i;
			}
		}
		
	}

}
