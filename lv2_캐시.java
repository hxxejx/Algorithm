package programmers;

import java.util.*;
import java.io.*;

public class lv2_캐시 {

	public static void main(String[] args) {
		int size = 3;
		String[] cities = {"Jeju", "Pangyo", "NewYork", "newyork"};
		
		solution(size, cities);

	}

	public static int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        if(cacheSize == 0) {
            answer = cities.length * 5;
            return answer;
        }
        
        Queue<String> cache = new LinkedList<>();
        
        for (int i = 0; i < cities.length; i++) {
			String city = cities[i].toUpperCase();
			
			if(cache.contains(city)) {
				answer ++;
				cache.remove(city);
			} else {
				answer += 5;
				if(cache.size() >= cacheSize) cache.poll();	
			}
			
			cache.add(city);
			
		}
        
        System.out.println(answer);
        
        return answer;
    }

}
