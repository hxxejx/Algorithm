package 문제풀이;

import java.io.*;
import java.util.*;

public class S3_1004_어린왕자 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int start_x = Integer.parseInt(st.nextToken());
			int start_y = Integer.parseInt(st.nextToken());
			int end_x = Integer.parseInt(st.nextToken());
			int end_y = Integer.parseInt(st.nextToken());
			
			int N = Integer.parseInt(br.readLine());

			int cnt = 0;
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				
				int planet_x = Integer.parseInt(st.nextToken());
				int planet_y = Integer.parseInt(st.nextToken());
				int planet_r = Integer.parseInt(st.nextToken());
				
				boolean startInPlanet = Math.pow(start_x - planet_x, 2) + Math.pow(start_y - planet_y, 2) > Math.pow(planet_r, 2) ? true : false;
				boolean endInPlanet = Math.pow(end_x - planet_x, 2) + Math.pow(end_y - planet_y, 2) > Math.pow(planet_r, 2) ? true : false;
				
				if(startInPlanet == true && endInPlanet == false) cnt++;
                else if(startInPlanet == false && endInPlanet == true) cnt++;
			}
			
			sb.append(cnt + "\n");
			
		}
		
		System.out.println(sb);
		
	}

}
