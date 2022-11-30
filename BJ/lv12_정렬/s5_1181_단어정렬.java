package lv12_정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class s5_1181_단어정렬 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 글자 개수 N
		String[] word = new String[N]; // 단어 담을 배열
		
		for(int i = 0; i<N; i++) {
			word[i] = br.readLine();
		} 
		
		Arrays.sort(word, new Comparator<String>(){
			@Override
			public int compare(String o1, String o2) {
				if(o1.length() == o2.length()) { // 길이가 같을 때
					return o1.compareTo(o2); // compareTo: 비교가 불가능한 시점에서 그 차이를 return
				} else { // 길이가 다를 때
					return o1.length() - o2.length(); // 길이로 비교
				}
			}
		});
		
		System.out.println(word[0]); // 첫줄 출력하기
		
		for(int i = 1; i < N; i++) {
			if(!word[i].equals(word[i-1])) { // 중복 지우기
				System.out.println(word[i]);
			}
			
		}

	}

}
