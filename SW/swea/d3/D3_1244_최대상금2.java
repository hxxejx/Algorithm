package swea.d3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class D3_1244_최대상금2 {

	static int count;
	static int result;
	static int[] num;
	static String s;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		File file = new File("res/D3_1244_최대상금.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int C = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= C; tc++) {
			String[] str = br.readLine().split(" ");
			
			count = Integer.parseInt(str[1]);
			
			String[] arr = str[0].split("");
			num = new int[str[0].length()];
			
			
			for(int i = 0; i < arr.length; i++) {
				num[i] = Integer.parseInt(arr[i]);
			} //숫자 배열에 넣기
			
			result = 0;
			dfs(0,0);
			System.out.println("#" + tc + " " + result);
		}
	}
	
	public static void dfs(int k, int cnt) {
		
		int tmp = 0;
		s = "";

		if(cnt == count) {
			Arrays.stream(num).forEach(x -> s += String.valueOf(x));
			//배열 ""으로 이어서 string으로 만드는 방법
			result = Math.max(result, Integer.parseInt(s));
			return;
		}
		
		for(int i = k; i<num.length; i++) {
			for(int j = i+1; j<num.length; j++) {
				if(num[i] <= num[j]) { //i보다 j가 크거나 같으면
					tmp = num[i];
					num[i] = num[j];
					num[j] = tmp; //둘 자리를 바꿈
					dfs(i, cnt+1); //i 다음부터 다시 돌아서 
					tmp = num[i];
					num[i] = num[j];
					num[j] = tmp; //다시 돌려놓음
				}
			}
		}
	}

}
