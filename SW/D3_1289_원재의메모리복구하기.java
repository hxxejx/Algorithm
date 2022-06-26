package com.ssafy.im;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

/*
 * 숫자가 몇 번 달라지는지 카운트
 * 	>> boolean과 charAt 사용
 *  >> if를 써서 boolean 값이 true에 숫자가 1이면 그대로 두기. false에 숫자가 1이면 카운트+++, true에 숫자가 0이면 카운트++, false에 숫자가 0이면 그대로
 */
public class D3_1289_원재의메모리복구하기 {
	public static void main(String args[]) throws Exception
	{
		File file = new File("res/D3_1289_원재의메모리복구하기.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 테스트 케이스 N	
		
		//System.out.println(N);
		
		for(int i = 0; i<N; i++) {
			String num = br.readLine(); // 원래 값
			//System.out.println(num);
			boolean sw = false; // 값 변환 스위치 기본값 false = 0
			int count = 0; // 몇 번 바뀌는지 세기
			for(int j = 0; j < num.length(); j++) {
				if(num.charAt(j) == '1' && sw == false) {
					sw = true;
					count++;
				} else if (num.charAt(j) == '1' && sw == true) {
					continue;
				} else if (num.charAt(j) == '0' && sw == false) {
					continue;
				} else if (num.charAt(j) == '0' && sw == true) {
					sw = false;
					count++;
				} 
			}
			System.out.println("#" + (i+1) + " " + count);
		} 	
	}
}
