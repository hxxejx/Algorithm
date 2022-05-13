
import java.io.*;
import java.util.*;

public class DijkstraTest {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int V = Integer.parseInt(br.readLine());
		
		int[][] adjMatrix = new int[V][V];
		int start = 0;
		
		StringTokenizer st = null;
		for(int i = 0; i < V; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < V; j++) {
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[] distance = new int[V]; // 출발지에서 자신으로 오는 최소비용
		boolean[] visited = new boolean[V]; // 최소비용 확정여부
		
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start] = 0;
		
		for(int i = 0; i < V; i++) {
			// 단계1 : 최소비용이 확정되지 않은 정점중 최소비용의 정점 선택 
			int min = Integer.MAX_VALUE, current=0;
			for(int j = 0; j < V; j++) {
				if(!visited[j] && min>distance[j]) {
					min = distance[j];
					current = j;
				}
			}
			
			// 최소비용 확정
			visited[current] = true;
			
			// 단계2 : 선택된 정점을 경유지로 하여 아직 최소비용이 확정되지 않은 다른 정점의 최소비용을 고려
			for (int j = 0; j < V; j++) {
				//확정되지 않았고, 그쪽으로 갈 수 있어야 함
				if(!visited[j] && adjMatrix[current][j] != 0 &&
						// current에서 j까지 오는 최소 비용이 기존의 출발지에서 j까지 오는 최소 비용보다 작음
						distance[j] > distance[current] + adjMatrix[current][j])
					distance[j] = distance[current] + adjMatrix[current][j];
			}
			
		}
		
		System.out.println(Arrays.toString(distance));
	}

}
