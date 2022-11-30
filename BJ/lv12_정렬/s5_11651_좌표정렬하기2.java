package lv12_정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class s5_11651_좌표정렬하기2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 점의 개수 N
		int[][] num = new int[N][2]; // x, y 좌표 두 개
		
		StringTokenizer st;
		
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			num[i][0] = Integer.parseInt(st.nextToken()); // x좌표
			num[i][1] = Integer.parseInt(st.nextToken()); // y좌표
		} 
		
		Arrays.sort(num, new Comparator<int[]>(){ //2차원 배열 정렬 검색했더니 나옴.. 클래스
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1]) { // y 좌표가 같을때
					return o1[0] - o2[0]; // x 좌표로 비교
				} else { // y 좌표가 다를 때
					return o1[1] - o2[1]; // y 좌표로 비교
				}
			}
		});
		
		for(int i = 0; i < N; i++) {
			System.out.println(num[i][0] + " " + num[i][1]);
		}

	}

}
