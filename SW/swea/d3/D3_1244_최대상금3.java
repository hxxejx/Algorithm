package swea.d3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D3_1244_최대상금3 {

	static int count;
	static int result;
	static char[] num;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		File file = new File("res/D3_1244_최대상금.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int C = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= C; tc++) {
			String[] str = br.readLine().split(" ");
			count = Integer.parseInt(str[1]);
			num = new char[str[0].length()];
			
			for(int i = 0; i < str[0].length(); i++) {
				num[i] = str[0].charAt(i);
			} //숫자를 char 형태로 배열에 넣기
			
			result = 0;
			dfs(0,0);
			System.out.println("#" + tc + " " + result);
		}
	}
	
	public static void dfs(int k, int cnt) {	
		char tmp = 0;

		if(cnt == count) {
			String s = new String(num); //char 배열을 string으로 바꾸기
			result = Math.max(result, Integer.parseInt(s));
			return;
		}
		
		for(int i = k; i<num.length; i++) {
			for(int j = i+1; j<num.length; j++) {
				int num1 = num[i] - '0'; //char를 int로 바꿔서 비교
				int num2 = num[j] - '0';
				if(num1 <= num2) { //num[i]보다 num[j]가 크거나 같으면
					tmp = num[i];
					num[i] = num[j];
					num[j] = tmp; //둘 자리를 바꿈
					dfs(i, cnt+1); //dfs 돌리기
					tmp = num[i];
					num[i] = num[j];
					num[j] = tmp; //다시 돌려놓음  
				}
			}
		}
	}

}
