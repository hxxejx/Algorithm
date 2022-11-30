package com.ssafy.im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D2_1954_달팽이숫자 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // 테스트케이스 T
		
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[N][N];
			arr[0][0] = 1;
			
			int x = 0; //x 좌표
			int y = 0; //y 좌표
			int num = 1; // 숫자
			int length = N-1; // 한 변의 길이(0부터 시작하기 때문에 -1)
			
			while(true) {
				if(num == N*N) break;
				if(num==1) {
					for (int i =0; i < length; i++)
						arr[x][++y] = ++num; //오른쪽으로 길이만큼 +
				} 
				for (int i = 0; i < length; i++)
					arr[++x][y] = ++num; //아래로 길이만큼 +
				for (int i = 0; i < length; i++)
					arr[x][--y] = ++num; //왼쪽으로 길이만큼 -
				length--; // 한 바퀴를 돌고 나서 길이를 줄여 줌
				for (int i = 0; i < length; i++) //위로 길이만큼
					arr[--x][y] = ++num;
				for (int i =0; i < length; i++) //다시 오른쪽으로 길이만큼
					arr[x][++y] = ++num;
				length--; //한바퀴를 돌고 나서 길이를 줄여 줌
			}
			
			System.out.println("#" + tc);
			for(int i = 0; i < arr.length; i++) {
				for(int j = 0; j < arr.length; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
		}
	}
}