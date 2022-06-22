import java.io.*;
import java.util.*;

/*
 * 입력
 * 1. 배달해야 하는 장소의 수 N(출발지는 1)
 * 2. 장소와 이동하는 비용(간선)
 * 출력
 * 1. 최소 비용
 * 
 * >>
 */
public class JO_1681_해밀턴순환회로2_허은지 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[N][N];
		
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
//		for(int i = 0; i<N; i++) {
//			for(int j = 0; j<N; j++) {
//				System.out.print(arr[i][j]);
//			}
//			System.out.println();
//		}
		
		int start = 0;
		int[] distance = new int[N]; // 출발지에서 자신으로 오는 최소비용
		boolean[] visited = new boolean[N]; // 최소비용 확정여부
		
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start] = 0;
		
		
		for(int i = 0; i < N; i++) {
			// 단계1 : 최소비용이 확정되지 않은 정점중 최소비용의 정점 선택 
			int min = Integer.MAX_VALUE, current=0;
			for(int j = 0; j < N; j++) {
				if(!visited[j] && min>distance[j]) {
					min = distance[j];
					current = j;
				}
			}
			
			// 최소비용 확정
			visited[current] = true;
			
			// 단계2 : 선택된 정점을 경유지로 하여 아직 최소비용이 확정되지 않은 다른 정점의 최소비용을 고려
			for (int j = 0; j < N; j++) {
				//확정되지 않았고, 그쪽으로 갈 수 있어야 함
				if(!visited[j] && arr[current][j] != 0 &&
						// current에서 j까지 오는 최소 비용이 기존의 출발지에서 j까지 오는 최소 비용보다 작음
						distance[j] > distance[current] + arr[current][j])
					distance[j] = distance[current] + arr[current][j];
			}
			
		}
		
		int ans = 0;
		for (int i = 0; i < distance.length; i++) {
			ans += distance[i];
		}
		
		System.out.println(Arrays.toString(distance));
		System.out.println(ans);
		
	}

}
