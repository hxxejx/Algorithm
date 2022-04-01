package com.ssafy.im;

import java.io.*;
import java.util.*;

public class D4_3124_최소스패닝트리 {
	static int N, E;
	static int[] arr;
	static boolean[] checked;
	static PriorityQueue<line> pq;
	static ArrayList<line> al;
	
	static class line {
		int A, B, C;
		
		line(int A, int B, int C) {
			this.A = A;
			this.B = B;
			this.C = C;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			arr = new int[N+1];
			checked = new boolean[N+1];
			
			pq = new PriorityQueue<>(new lineComparator());
			al = new ArrayList<>();
			
			for(int i = 0; i<E; i++) {
				st = new StringTokenizer(br.readLine());
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				int C = Integer.parseInt(st.nextToken());
				pq.add(new line(A, B, C));
			}
			
			kruskal();
			int ans = 0;
			for(int i=0; i<al.size(); i++) {
				ans += al.get(i).C;
			}
			sb.append("#").append(tc).append(" ").append(ans);
		}
		
		System.out.println(sb);
		
	}
	
	static class lineComparator implements Comparator<line> {
		@Override
		public int compare(line o1, line o2) {
			return o1.C > o2.C ? 1 : -1;
		}

	}
	
	static void kruskal() {
		for(int i=1; i<=N; i++) {
			arr[i] = i;
		}
		
		for(int i=0; i<E; i++) {
			line l = pq.poll();
			if(find(l.A) == find(l.B)) {
				continue;
			}
			union(l.A, l.B);
			al.add(l);
		}
		
	}
	
	static void union(int a, int b) { 
		a = find(a);
		b = find(b);
		if(a>b) arr[a] = b;
		else arr[b] = a;
	}
	
	static int find(int n) { 
		if (arr[n] == n) return n;
		else return find(arr[n]);
	}

}
