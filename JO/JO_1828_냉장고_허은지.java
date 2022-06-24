import java.util.*;
import java.io.*;

/*
 * 입력
 * 1. 화학물질 수 N
 * 2. 최저보관온도 최고보관온도
 * 출력
 * 최소로 필요한 냉장고의 대수
 * 
 * >> 안 겹치는 게 몇 개인지 센다..
 */
public class JO_1828_냉장고_허은지 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		List<Integer> min = new ArrayList<>();
		List<Integer> max = new ArrayList<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		min.add(Integer.parseInt(st.nextToken()));
		max.add(Integer.parseInt(st.nextToken()));
		
		int count = 1;
		
		outer: for (int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int tempMin = Integer.parseInt(st.nextToken());
			int tempMax = Integer.parseInt(st.nextToken());
			
//			System.out.println(tempMin);
//			System.out.println(tempMax);
//			System.out.println("이미 있는 냉장고: " + count);
			
			for(int j = 0; j < min.size(); j++) {
				if(tempMax>=min.get(j) && tempMin<=max.get(j)) continue outer;
				if(j==min.size()-1) {
					count++;
					min.add(tempMin);
					max.add(tempMax);
				}
			}
		}
		
		System.out.println(count);
		
	}

}
