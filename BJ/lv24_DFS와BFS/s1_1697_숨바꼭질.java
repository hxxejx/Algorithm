package lv24_DFS와BFS;

import java.io.*;
import java.util.*;

/*
 * 입력
 * 1. 수빈이가 있는 위치 N 동생이 있는 위치 K
 * 출력
 * 1. 동생을 찾는 가장 빠른 시간
 * 
 * >> bfs, 가지치기
 */
public class s1_1697_숨바꼭질 {
	static int N, K;
	static int min = Integer.MAX_VALUE;
	static int[] count;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		count = new int[10001];
		
		bfs(N);
 
	}

	private static void bfs(int n) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(n);
		count[n] = 1;

		while(!queue.isEmpty()) {
			int temp = queue.poll();
			
			
			for(int i = 0; i<3; i++) {
				if(i==0) {
					n = temp + 1;
				}
				else if(i==1) {
					n = temp - 1;
				}
				else if(i==2 ) {
					n = temp * 2;
				}
				
				if(n==K) {
					System.out.println(count[temp]);
					return;
				}
				
				if(n >= 0 && n < count.length && count[n] == 0) {
					queue.add(n);
					count[n] = count[temp] + 1;
				}
			}
		}
		
		
		  
		
	}

}
