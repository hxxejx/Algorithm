package 문제풀이;

import java.io.*;
import java.util.*;

public class B5_10809_알파벳찾기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String str = br.readLine();
		
		int[] abc = new int[26];
		
		for (int i = 0; i < 26; i++) {
			abc[i] = -1;
		}
		
		for (int i = 0; i < str.length(); i++) {
			int index = str.charAt(i) - 'a';
			if(abc[index] == -1) abc[index] = i;
		}
		
		for (int i = 0; i < 26; i++) {
			sb.append(abc[i] + " ");
		}
		
		System.out.println(sb);


	}

}
