package lv14_백트래킹;

import java.util.*;
import java.io.*;

/*
 * 입력
 * 스도쿠판 비어 있는 숫자는 0
 * 출력
 * 스도쿠 판의 최종 모습
 * 
 * >> 세로 가로 아홉칸 봐서 겹치지 않는 숫자 삽입
 */
public class g4_2580_스도쿠 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] arr = new int[9][9];
		
		for(int i = 0; i<9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j<9; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		outer: while(true) {
			for(int i = 0; i<9; i++) {
				for(int j = 0; j<9; j++) {
					if(arr[i][j]==0) {
						check(i, j, arr);
					}
				}
			}
			
			for(int i = 0; i<9; i++) {
				for(int j = 0; j<9; j++) {
					if(arr[i][j]==0) continue outer;
				}
			}
			break;
		}
		
		for(int i = 0; i<9; i++) {
			for(int j = 0; j<9; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		
	}

	private static void check(int x, int y, int[][] arr) {
		boolean[] num = new boolean[10];
		
		//가로 체크
		for(int i = 0; i<9; i++) {
			num[arr[x][i]] = true;
		}

		//세로 체크
		for(int i = 0; i<9; i++) {
			num[arr[i][y]] = true;
		}

		//3*3 체크	
		for(int i = x/3*3; i < x/3*3+3; i++) {
			for(int j = y/3*3; j < y/3*3+3; j++) {
				num[arr[i][j]] = true;
			}
		}
		
		Queue<Integer> queue = new LinkedList<>();
		
		for(int i = 0; i<10; i++) {
			if(!num[i]) queue.add(i);
		}
		
		if(queue.size() == 1) arr[x][y] = queue.poll();
		
	}

}
