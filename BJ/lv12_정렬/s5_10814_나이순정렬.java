package lv12_정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class s5_10814_나이순정렬 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 회원 수 N
		String[][] info = new String[N][2]; // 나이, 이름 두 개
		
		StringTokenizer st;
		
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			info[i][0] = st.nextToken(); // 나이
			info[i][1] = st.nextToken(); // 이름
		} 
		
		Arrays.sort(info, new Comparator<String[]>(){
			@Override
			public int compare(String[] o1, String[] o2) {
				return Integer.parseInt(o1[0])-Integer.parseInt(o2[0]); // 나이로 비교
			}
		});
		
		for(int i = 0; i < N; i++) {
			System.out.println(info[i][0] + " " + info[i][1]);
		}

	}

}
