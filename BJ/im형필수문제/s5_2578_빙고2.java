package im형필수문제;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s5_2578_빙고2 {
	
	public static void main(String[] args) throws IOException {
		File file = new File("res/s5_2578_빙고.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] arr = new int[5][5];
		
		for(int i = 0; i<5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j<5; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i<5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 1; j<=5; j++) {
				
				
				int num = Integer.parseInt(st.nextToken());
				for(int ii = 0; ii<5; ii++) {
					for(int jj=0; jj<5; jj++) {
						if(num == arr[ii][jj]) arr[ii][jj] = 0;
					}
				}

				int bingo = 0;
				
				outer: for(int ii = 0; ii < 5; ii++) {
					for(int jj = 0; jj < 5; jj++) {
						if(arr[jj][ii] != 0) continue outer; 
					}
					bingo++;
				}
				
				outer: for(int ii = 0; ii < 5; ii++) {
					for(int jj = 0; jj < 5; jj++) {
						if(arr[ii][jj] != 0) continue outer; 
					}
					bingo++;
				}	
				
				outer: if(arr[0][0] == 0) {
					for(int ii = 1; ii < 5; ii++) {
						if(arr[ii][ii] != 0) break outer;
					}
					bingo++;
				}
				
				outer: if(arr[4][0] == 0) {
					for(int ii = 1; ii < 5; ii++) {
						if(arr[4-ii][ii] != 0) break outer;
					}
					bingo++;
				}
				
				if(bingo >= 3) {
					System.out.println(i*5+j);
					System.exit(0);
				}
			}
		}
	}
}
