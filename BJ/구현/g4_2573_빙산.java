package 구현;

import java.io.*;
import java.util.*;

/*
 * 입력
 * 1. 행 N 열 M
 * 2. 빙산이 차지하는 칸의 개수는 10000 이하
 * 3. 제일 바깥쪽은 무조건 0
 * 출력
 * 1. 빙산이 분리되는 최초의 시간
 * 2. 다 녹을 때까지 분리되지 않으면 0 출력
 * 조건
 * 1. 동서남북에 있는 0의 개수만큼 줄어든다
 * 2. 두 덩어리 이상으로 분리되면 끝
 */
public class g4_2573_빙산 {
	static int N, M, arr[][], tmp[][];
	static boolean visited[][];
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		tmp = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int year = 0;
		
		while(true) {
			// 빙산이 이미 존재하는지
			boolean iceberg = false;
			// 방문 배열은 해가 지날 때마다 초기화
			visited = new boolean[N][M];
			
			for (int i = 1; i < N-1; i++) {
				for (int j = 1; j < M-1; j++) {
					// 빙산이 있고, 방문한 적이 없을 때
					if(arr[i][j]!=0 && !visited[i][j]) {
						// 빙산이 이미 존재한다면(2개 이상) 최초의 시간 출력
						if(iceberg) {
							System.out.println(year);
							System.exit(0);
						}
						// 빙산이 존재하지 않는다면 방문 처리 후 이어진 빙산 계산
						visited[i][j] = true;
						iceberg = true;
						countIceberg(i, j);
					}
				}
			}
			
			// 일 년이 지났을 때
			year++;
			// 배열 복사
			clone(tmp, arr);
			// 빙산의 개수
			int count = 0;
			
			for (int i = 1; i < N-1; i++) {
				for (int j = 1; j < M-1; j++) {
					// 빙산 녹이기
					if(arr[i][j]!=0) {
						melt(i, j);
						count++;
					}
				}
			}
			
			// 빙산이 하나도 없으면 0 출력
			if(count==0) {
				System.out.println(0);
				System.exit(0);
			}
			
			// 남은 빙산이 있다면 다시 배열 복사
			clone(arr, tmp);

		}

	}

	private static void clone(int[][] a, int[][] b) {
		for (int i = 1; i < N-1; i++) {
			for (int j = 1; j < M-1; j++) {
				a[i][j] = b[i][j];
			}
		}
	}

	private static void melt(int i, int j) {
		for(int k = 0; k<4; k++) {
			int x = i+dx[k];
			int y = j+dy[k];
			if(arr[x][y]==0) tmp[i][j]--;
		}
		
		if(tmp[i][j]<0) tmp[i][j]=0;
	}

	private static void countIceberg(int i, int j) {
		for(int k = 0; k<4; k++) {
			int x = i+dx[k];
			int y = j+dy[k];
			if(arr[x][y]==0 || visited[x][y]) continue;
			visited[x][y] = true;
			countIceberg(x, y);
		}
		
	}
	
}
