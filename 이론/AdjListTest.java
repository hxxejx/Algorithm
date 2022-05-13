
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

public class AdjListTest {
	static int N;
	
	static class Node{
		
		int vertex;
		Node link;
		
		public Node(int vertex, Node link) {
			this.vertex = vertex;
			this.link = link;
		}

		@Override
		public String toString() {
			return "Node [vertex=" + vertex + ", link=" + link + "]";
		}
		
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); //정점 수
		int C = Integer.parseInt(br.readLine()); //간선 수
		
		Node[] adjList = new Node[N];	
		
		for(int i = 0; i<C; i++) { //정점수 크기로 생성
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			//무향이므로 간선 하나로 양방향 처리
			adjList[from] = new Node(to, adjList[from]);
			adjList[to] = new Node(from, adjList[to]);
		}
		
//		for(Node head : adjList) {
//			System.out.println(head);
//		}
		
		//bfs(adjList, 0);
		dfs(adjList, new boolean[N], 0);
	}

	public static void bfs(Node[] adjList, int start) {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[N];
		
		queue.add(start);
		visited[start] = true;
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			//System.out.println((char)(current+65));
			System.out.println(current);
			
			// current 정점의 인접정점 처리(단, 방문하지 않은 인접정점만)
			for(Node temp = adjList[current]; temp != null; temp = temp.link) { //adjList의 current부터 시작해서 temp가 null이 아닐 때만 돈다 temp 탐색이 끝나면 link를 따라간다
				if(!visited[temp.vertex]) { //temp.vertex => 노드에 저장된 정점 번호 -- 인접 여부만 따라가기 때문에 배열 볼 필요 없음
					queue.add(temp.vertex);
					visited[temp.vertex] = true;
				}
			}
		}
	}
	
	public static void dfs(Node[] adjList, boolean[] visited, int current) {
		visited[current] = true;
		System.out.println(current);
		
		for(Node temp = adjList[current]; temp != null; temp = temp.link) {
			if(!visited[temp.vertex]) {
				dfs(adjList, visited, temp.vertex);
			}
		}
		
	}
	
}
