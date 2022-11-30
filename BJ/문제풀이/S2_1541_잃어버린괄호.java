package 문제풀이;

import java.io.*;
import java.util.*;

public class S2_1541_잃어버린괄호 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		boolean plus = true;
		
		List<Character> list = new ArrayList<>();
		
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if(c == '-' || c == '+') list.add(c);
		}
		
		StringTokenizer st = new StringTokenizer(str, "+:-");
		
		int ans = Integer.parseInt(st.nextToken());
		
		if(list.size()==1) {
			int num = Integer.parseInt(st.nextToken());
			
			if(list.get(0) == '+') ans += num;
			else ans -= num;
		} else {
			int size = st.countTokens();
			
			for (int i = 0; i < size-1; i++) {
				int num = Integer.parseInt(st.nextToken());
				
				if(!plus) ans -= num;
				else if(list.get(i) == '+') ans += num;
				else if(list.get(i) == '-') {
					plus = false;
					ans -= num;
				}
			}
			
			int num = Integer.parseInt(st.nextToken());
			if(!plus) ans -= num;
			else ans += num;
		}
		
		System.out.println(ans);

	}

}
