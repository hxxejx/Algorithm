package im형필수문제;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 1. 1~5까지 빙고 칸
 * 2. 6~10까지 차례대로 사회자가 부르는 수
 * 3. 세 줄 빙고 나오면 빙고
 * 4. 사회자가 몇 번째 숫자를 외친 뒤 빙고가 나오는지 계산 후 출력
 * 
 * >> 숫자 부를 때마다 배열에 값 0 넣기
 * >> 1 넣고 나서 가로 세로 대각선 탐색으로 빙고 찾기(재귀로 하기)
 * >> 빙고 개수 세서 세 개 있으면 빙고 외치기
 */
public class s5_2578_빙고 {
	static int bingo;
	static int[][] arr = new int[5][5];
	
	public static void main(String[] args) throws IOException {
		File file = new File("res/s5_2578_빙고.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i = 0; i<5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j<5; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		} //빙고판 만들기
		
		for(int i = 0; i<5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 1; j<=5; j++) {
				
				
				int num = Integer.parseInt(st.nextToken());
				for(int ii = 0; ii<5; ii++) {
					for(int jj=0; jj<5; jj++) {
						if(num == arr[ii][jj]) arr[ii][jj] = 0; //사회자가 부르는 값과 빙고 판의 값이 같으면 빙고 판의 값 0
					}
				} //빙고판 0 만들기
				
				//빙고판 확인
//				for(int ii = 0; ii<5; ii++) {
//					for(int jj=0; jj<5; jj++) {
//						System.out.print(arr[ii][jj]+ " ");
//					}
//					System.out.println();
//				}
//				System.out.println("--------" + bingo);

				//탐색하기
				bingo = 0;
				
				row();
				col();
				diag1();
				diag2();
				
				if(bingo >= 3) {
					System.out.println(i*5+j);
					System.exit(0);
				}
			}
		}
	}

	private static void diag2() { // 대각선 / 방향 탐색
		if(arr[4][0] == 0) { 
			for(int i = 1; i < 5; i++) {
				if(arr[4-i][i] != 0) return; //빙고가 안 이어지면 멈춤
			}
			bingo++;
		}
	}

	private static void diag1() { // 대각선 \ 방향 탐색
		if(arr[0][0] == 0) { 
			for(int i = 1; i < 5; i++) {
				if(arr[i][i] != 0) return; //빙고가 안 이어지면 멈춤
			}
			bingo++;
		}
	}

	private static void col() { // 세로 방향 탐색
		outer: for(int i = 0; i < 5; i++) { 
			for(int j = 0; j < 5; j++) {
				if(arr[i][j] != 0) continue outer;
			}
			bingo++;
		}	
	}

	private static void row() { // 가로 방향 탐색
		outer: for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				if(arr[j][i] != 0) continue outer; 
			} 
			bingo++;
		}
	}
}
