
/*
7
8
0 1
0 2
1 3
1 4
2 4
3 5
4 5
5 6
 */
//무향 그래프
import java.util.*;
import java.io.*;

public class AdjMatrixTest {
	static int N;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); //정점 수
		int C = Integer.parseInt(br.readLine()); //간선 수
		
		int[][] adjMatrix = new int[N][N];
		
		for(int i = 0; i<C; i++) { //정점수 크기로 생성
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			//무향이므로 간선 하나로 양방향 처리
			adjMatrix[from][to] = adjMatrix[to][from] = 1;
		}
		
//		for(int[] is : adjMatrix) {
//			System.out.println(Arrays.toString(is));
//		}
		
		//bfs(adjMatrix, 0);
		dfs(adjMatrix, new boolean[N], 0);
	}
	
	public static void bfs(int[][] adjMatrix, int start) {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[N];
		
		queue.add(start);
		visited[start] = true;
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			//System.out.println((char)(current+65));
			System.out.println(current);
			
			// current 정점의 인접정점 처리(단, 방문하지 않은 인접정점만)
			for(int i = 0; i<N; i++) {
				if(!visited[i] && adjMatrix[current][i]!=0) {
					queue.add(i);
					visited[i] = true;
				}
			}
		}
	}
	
	public static void dfs(int[][] adjMatrix, boolean[] visited, int current) {
		visited[current] = true;
		System.out.println(current);
		
		// current 정점의 인접정점 처리(단, 방문하지 않은 인접정점만)
		for(int i = 0; i<N; i++) {
			if(!visited[i] && adjMatrix[current][i]==1) {
				dfs(adjMatrix, visited, i);
			}
		}
	}

}
