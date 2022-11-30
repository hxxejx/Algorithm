package lv27_트리;

import java.io.*;
import java.util.*;

public class s2_11725_트리의부모찾기 {
	static int[] parents;
	static boolean[] visit;
	static ArrayList<Integer>[] list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		list = new ArrayList[N + 1];
		visit = new boolean[N + 1];
		parents = new int[N + 1];
		
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < N - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());

			list[n1].add(n2);
			list[n2].add(n1);
		}

		dfs(1);
		
		for (int i = 2; i <= N; i++) {
			System.out.println(parents[i]);
		}

	}

	public static void dfs(int v) {
		visit[v] = true;

		for (int i : list[v]) {
			if (!visit[i]) {
				parents[i] = v;
				dfs(i);
			}
		}
	}
}
