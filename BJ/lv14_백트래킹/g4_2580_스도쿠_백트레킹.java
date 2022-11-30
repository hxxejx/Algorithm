package lv14_백트래킹;

import java.util.*;
import java.io.*;

/*
 * 입력
 * 스도쿠판 비어 있는 숫자는 0
 * 출력
 * 스도쿠 판의 최종 모습
 * 
 * >> 백트레킹으로 풀기
 * >> dfs   
 */
public class g4_2580_스도쿠_백트레킹 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] arr = new int[9][9];
		
		for(int i = 0; i<9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j<9; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		b(0, 0, arr);
		
	}
	
	static void b(int x, int y, int[][] arr) {

        if (y == 9) {
            b(x + 1, 0, arr);
            return;
        }

        if (x == 9) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
            System.exit(0);
        }

        if (arr[x][y] == 0) {
            for (int i = 1; i <= 9; i++) { 
                if (check(x, y, i, arr)) {
                    arr[x][y] = i;
                    b(x, y + 1, arr);
                }
            }
            arr[x][y] = 0;
            return;
        }

        b(x, y + 1, arr);
    }
	
	static boolean check(int x, int y, int num, int[][] arr) {

        //가로 체크
        for (int i = 0; i < 9; i++) {
            if (arr[x][i] == num)
                return false;
        }

        //세로 체크
        for (int j = 0; j < 9; j++) {
            if (arr[j][y] == num) {
                return false;
            }
        }

        //3*3 체크
        for(int i = x/3*3; i < x/3*3+3; i++) {
			for(int j = y/3*3; j < y/3*3+3; j++) {
                if (arr[i][j] == num)
                    return false;
            }
        }

        return true;
    }
}
