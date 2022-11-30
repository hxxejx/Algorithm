package A형기출문제;

import java.io.*;
import java.util.*;

/*
 * 입력
 * 1. 행의 수 N 열의 수 M 공격 거리 제한 D
 * 2. 0 빈칸 1 적이 있는 칸
 * 출력
 * 1. 궁수의 공격으로 제거할 수 있는 적의 최대 수
 * 조건
 * 1. 격자 바로 아래 성이 있음
 * 2. 성이 있는 곳에 궁수 세 명 배치
 * 3. 가장 가까운 적을 공격, 여럿일 때는 가장 왼쪽에 있는 적 공격
 * 4. 모든 적이 격자판에서 제외되면 게임 종료
 * 5. 궁수의 위치는 변하지 않음
 * 
 * >> 조합 + dfs
 * >> D만큼을 전부 숫자로 넣기
 */
public class g4_17135_캐슬디펜스 {
	static int N, M, D, max, arr[][];
	static Queue<int[]> queue = new ArrayDeque<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		arr = new int[N+1][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]==1) queue.add(new int[] {i, j});
			}
		}
		
		archer(1, 0);

	}

	private static void archer(int cnt, int start) {
		if(cnt == 3) {
			max = Math.max(attack(), max);
			return;
		}
		
		for (int i = start; i < M; i++) {
			arr[N][i] = i;
			archer(cnt+1, i+1);
		}
		
	}

	private static int attack() {
		int enemy= 0;
		
		while(!queue.isEmpty()) { // 큐가 비면 break
			int[][] kill = new int[3][2];
			
			for (int i = 0; i < 3; i++) {
				
			}
		}
		
		return enemy;
	}

}
