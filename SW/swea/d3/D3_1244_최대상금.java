package swea.d3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D3_1244_최대상금 {

	/*
	 * 1. 첫줄 C 테스트 케이스
	 * 2. 숫자 나오고 띄어쓰기 후 교환 횟수 >> split 사용
	 * 3. 출력: "#" + C + " " + max
	 * 
	 * >> 가장 큰 수 찾아서 무조건 앞으로 넣기
	 * >> 넣으려는 자리에 있는 숫자가 크면 그 다음에 넣기
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		File file = new File("res/D3_1244_최대상금.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int C = Integer.parseInt(br.readLine());
		int max = 10;
		int cnt = 0;
		
		for(int tc = 1; tc <= C; tc++) {
			String[] str = br.readLine().split(" ");
			
			int count = Integer.parseInt(str[1]);
			
			String[] arr = str[0].split("");
			int[] num = new int[str[0].length()];
			for(int i = 0; i < str[0].length(); i++) {
				num[i] = Integer.parseInt(arr[i]);
			} //숫자 배열에 넣기
			
			for(int i = 0; i<str[0].length(); i++) {
				if(num[i] >= max) {
					max = num[i];
					cnt++;
				}
			}
			
			for(int i = 0; i<count; i++) {
				
			}
			
		}
	}

}
