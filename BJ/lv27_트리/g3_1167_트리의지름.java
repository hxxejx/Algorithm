package lv27_트리;

import java.io.*;
import java.util.*;

public class g3_1167_트리의지름 {
	static int node, max;
	static boolean[] visit;
	static ArrayList<int[]>[] list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		list = new ArrayList[N + 1];
		visit = new boolean[N + 1];
		
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < N - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			while(true) {
				int end = Integer.parseInt(st.nextToken());
				if(end == -1) break;
				int cost = Integer.parseInt(st.nextToken());
				list[start].add(new int[] {end, cost});
			}
		}
		
		dfs(1, 0);
		
		visit = new boolean[N + 1];
		
		dfs(node, 0);
		
		System.out.println(max);

	}

	public static void dfs(int v, int len) {
		if(len>max) {
			max = len;
			node = v;
		}
		
		visit[v] = true;

		for (int i = 0; i<list[v].size(); i++) {
			int[] node = list[v].get(i);
			if (!visit[node[0]]) {
				visit[node[0]] = true;
				dfs(node[0], node[1] + len);
			}
		}
	}
}
