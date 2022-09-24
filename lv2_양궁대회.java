package programmers;

import java.io.*;
import java.util.*;

public class lv2_양궁대회 {

	public static void main(String[] args) throws Exception {
		int n = 5;
		int[] info = {2,1,1,1,0,0,0,0,0,0,0};
		int[] answer = new int[11];
		
		answer = solution(n, info);
		
		for (int i = 0; i < answer.length; i++) {
			System.out.println(answer[i]);
		}
	}

	private static int[] solution(int n, int[] info) {
		int[] answer = new int[11];
		
		int arrow = 0;
		int score = 0;
		for (int i = 0; i < 11; i++) {
			if(info[i] > 0) {
				arrow += info[i];
				score += info[i] * (10-i);
			}
		}
		
		dfs(0, n, 0, answer, info, 0);
		
		
		
		if(answer.length == 0) answer[0] = -1; 
		
        return answer;
	}

	private static void dfs(int i, int n, int j, int[] answer, int[] apeach, int max) {
		if(j == n) {
			int[] ryan = new int[11];
			for (int k = 0; k < 11; k++) {
				ryan[10-k]++;
			}
			
			int ryanScore = 0;
			int apeachScore = 0;
			
			for (int k = 0; k < 11; k++) {
				int score = 10 - k;
				if(apeach[i] == 0) continue;
				else if(ryan[i] > apeach[i]) ryanScore += score;
				else apeachScore += score;
				
				if(ryanScore - apeachScore > max) {
					max = ryanScore - apeachScore;
					answer = ryan;
				}
				
				return;
			}
			
			for (int k = i; k < 11; k++) {
				
				dfs(i, n, j+1, answer, apeach, 0);
			}
		}
		
	}

}
