package boj_미완;

import java.io.*;
import java.util.*;

/*
 * 입력
 * 1. 테스트 케이스 개수 K
 * 2. 그래프의 정점의 개수 V 간선의 개수 E
 * 3. E개의 줄에 간선의 정보 인접한 두 정점의 번호 u v
 * 출력
 * 1. 이분 그래프이면 YES, 아니면 NO
 * 조건
 * 1. 집합을 둘로 나눴을 때 각 집합에 속한 정점끼리 인접하지 않으면 이분 그래프
 * 
 * >> dfs
 */
public class g4_1707_이분그래프 {
	static int V;
	static int[][] arr;
	static int[] check;
	static boolean[] visited;
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		int K = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc<K; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			arr = new int[V][V];
			check = new int[V];
			visited = new boolean[V];
			
			for(int i = 0; i<E; i++) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				
				arr[u-1][v-1] = arr[v-1][u-1] = 1;
			}
			
			dfs(0);
			
		}
		
		System.out.println(sb);
		
	}

	private static void dfs(int start) {
		visited[start] = true;
		
		for(int i = 0; i<V; i++) { 
			if(!visited[i]) check[i] = i;
		}
		
		outer: for(int i = 0; i<check.length-1; i++) {
			for(int j = i+1; j<check.length; j++) {
				if(arr[i][j] == 1) break outer;
				sb.append("YES\n");
				return;
			}
		}
		
		for(int i = start; i<V; i++) {
			if(visited[i] && arr[start][i] == 0) dfs(i);
		}
		
		sb.append("NO\n");
		return;
		
		
	}

}
