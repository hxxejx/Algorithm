package lv24_DFS와BFS;

import java.util.*;

import lv24_DFS와BFS.g5_7576_토마토2.Tomato;

import java.io.*;

/*
 * 입력
 * 1. 상자의 크기 M 가로 N 세로
 * 2. 토마토의 정보(1 익은 토마토 0 익지 않은 토마토 -1 토마토 없는 칸)
 * 출력
 * 1. 토마토가 모두 익을 때까지의 최소 날짜(모든 토마토가 익어 있으면 0 모두 익지 못하면 -1)
 * 조건
 * 1. 토마토는 사방으로만 익힐 수 있음 대각선으로는 익힐 수 없음
 * 
 * >> bfs 사용
 */
public class g5_7576_토마토 {
	
	static class Tomato {
		public int x1, y1;
		public Tomato(int x1, int y1) {
			this.x1 = x1;
			this.y1 = y1;
		}
	}
	
	static int M, N, zeroSize, oneSize;
	static int[][] box;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static Queue<Tomato> zero = new LinkedList<>();
	static Queue<Tomato> one = new LinkedList<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		box = new int[N][M];
		
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<M; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
				//안 익은 토마토의 위치를 큐에 넣기(너무 많아서 시간 초과)
				if(box[i][j]==0) zero.add(new Tomato(i,j));
				//익은 토마토의 위치를 큐에 넣기
				else if(box[i][j]==1) one.add(new Tomato(i,j));
			}
		}
		
		//안 익은 토마토의 개수
		zeroSize = zero.size();
		
		//안 익은 토마토가 0개면 0 출력 후 종료
		if(zeroSize == 0) {
			System.out.println(0);
			System.exit(0);
		}
		
		//안 익은 토마토의 개수만큼 사방 탐색
		for(int i = 0; i<zeroSize; i++) {
			find();
		}
		
		int count = 0;
		
		//안 익은 토마토가 0이 될 때까지 돌림
		while(zeroSize!=0) {
			oneSize = one.size();
			bfs();
			count++;
		}
		
		System.out.println(count);	
	}

	private static void bfs() {
		for(int n = 0; n<oneSize; n++) {
			Tomato t = one.poll();
			int i = t.x1;
			int j = t.y1;
			
			//4방 탐색
			for(int k = 0; k < 4; k++) {
				int x = i + dx[k];
				int y = j + dy[k];
					
				if(x<0 || x>=N || y<0 || y>=M) continue;
				
				//토마토가 익지 않았을 때
				if(box[x][y]==0) {
					//토마토를 익힌다
					box[x][y] = 1;
					//익은 토마토를 큐에 넣음(날짜 하루 추가)
					one.add(new Tomato(x,y));
					//안 익은 토마토의 개수 줄이기
					zeroSize--;
				}
			}
		}
		
		
	}
	
	//시간 초과
	private static void find() {
		Tomato t = zero.poll();
		int i = t.x1;
		int j = t.y1;
		
		for(int k = 0; k < 4; k++) {
			int x = i + dx[k];
			int y = j + dy[k];
			
			if(x<0 || x>=N || y<0 || y>=M) continue;
			//주변에 벽이 없으면 리턴
			if(box[x][y]!=-1) return;
		}
		
		//주변에 벽만 있으면 -1 출력 후 종료
		System.out.println(-1);
		System.exit(0);
		
	}
}