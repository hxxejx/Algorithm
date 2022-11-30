package 구현;

import java.io.*;
import java.util.*;

/*
 * 입력
 * 1. N M
 * 2. A와 B 사이에 중량제한이 C인 다리 존재
 * 3. 공장이 위치해 있는 섬의 번호
 * 출력
 * 1. 한번의 이동에서 옮길 수 있는 물품들의 중량의 최댓값
 * 
 * >> 이분탐색 dfs
 */
public class g4_1939_중량제한 {
	static int ans;
	static boolean[] visited;
	static List<City>[] list;
	
	static class City{
		int to;
		int w;
		
		public City(int to, int w) {
			this.to = to;
			this.w = w;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N+1];
		for (int i = 0; i < N+1; i++) {
			list[i] = new ArrayList<>();
		}
		
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			list[A].add(new City(B, C));
			list[B].add(new City(A, C));
			
			max = Math.max(max, C);
		}
		
		st = new StringTokenizer(br.readLine());
		
		int from = Integer.parseInt(st.nextToken());
		int to = Integer.parseInt(st.nextToken());
		
		while(min<= max) {
			int mid = (min+max)/2;
			
			ans = -1;
			visited = new boolean[N+1];
			dfs(from,to,mid);
			
			if(ans != -1) min = mid+1;
			else max = mid-1;
		}
		
		System.out.println(max);
		
	}
	
	static void dfs(int pos, int target, int limit) {
		if(pos == target) {
			ans = pos; 
			return;
		}
		
		visited[pos]= true;
		
		for(City c : list[pos]) {
			if(!visited[c.to] && limit <= c.w ) {
				dfs(c.to, target, limit);
			}
		}
	}

}
