package Lv2;


import java.util.*;
import java.io.*;

public class lv2_뉴스클러스터링 {

	public static void main(String[] args) {

		String str1 = "aa1+aa2";
		String str2 = "AAAA12";
		
		solution(str1, str2);

	}

	public static int solution(String str1, String str2) {
        int answer = 0;
        
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        
        int str1len = str1.length();
        int str2len = str2.length();
        
        List<String> s1 = new ArrayList<>();
        List<String> s2 = new ArrayList<>();
        
        List<String> intersection = new ArrayList<>();
        List<String> union = new ArrayList<>();

        for (int i = 0; i < str1len - 1; i++) {
        	char tmp1 = str1.charAt(i);
        	char tmp2 = str1.charAt(i+1);
        	if(tmp1 < 'A' || tmp1 > 'Z' || tmp2 < 'A' || tmp2 > 'Z') continue;
			s1.add(str1.substring(i, i+2));
		}
        
        for (int i = 0; i < str2len - 1; i++) {
        	char tmp1 = str2.charAt(i);
        	char tmp2 = str2.charAt(i+1);
        	if(tmp1 < 'A' || tmp1 > 'Z' || tmp2 < 'A' || tmp2 > 'Z') continue;
			s2.add(str2.substring(i, i+2));
		}
        
        System.out.println(s1);
        System.out.println(s2);

        outer: for (int i = 0; i < s1.size(); i++) {
        	union.add(s1.get(i));
        	
			for (int j = 0; j < s2.size(); j++) {
				if(s1.get(i).equals(s2.get(j))) {
					s2.remove(j);
					intersection.add(s1.get(i));
					continue outer;
				}
			}
			
		}

        for (int i = 0; i < s2.size(); i++) {
			union.add(s2.get(i));
		}
        
        
        
        if(union.isEmpty()) answer = 65536;
        else {
        	answer = (int) (((double) intersection.size() / (double) union.size()) * 65536);
        }

        return answer;
    }

}
