package 구현;

import java.io.*;
import java.util.*;

public class S5_1316_그룹단어체커 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int cnt = 0;
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			
			boolean[] group = new boolean[26];
			boolean isGroup = true;
			int tmp = -1;
			
			for (int j = 0; j < str.length(); j++) {
				int word = str.charAt(j) - 'a';
				
				if(tmp == word) continue;
				tmp = word;
				
				if(!group[word]) group[word] = true;
				else isGroup = false;
				
			}
			
			if(isGroup) cnt++;
		}
		
		System.out.println(cnt);

	}

}
