package lv11_브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class s5_1436_영화감독숌 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // N번째 영화
		int count = 0;
		int num = 665; // 666부터 존재하니까 665부터 하기
		String movie = null;
		
		while(count != N) { //N번째 영화 찾을 때까지
			num++; //숫자 하나씩 늘려가면서
			movie = Integer.toString(num);
			if(movie.contains("666")) { // 666 포함된 숫자 찾으면
				count++; //N번째 영화로 등록
			}
		}		
		System.out.println(movie); //N번째 영화 숫자 출력
	}
}
