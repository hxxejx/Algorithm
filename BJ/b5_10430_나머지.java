package 구현;

import java.io.*;
import java.util.*;

public class b5_10430_나머지 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		sb.append((A+B)%C).append("\n");
		sb.append(((A%C)+(B%C))%C).append("\n");
		sb.append((A*B)%C).append("\n");
		sb.append(((A%C)*(B%C))%C).append("\n");
		
		System.out.println(sb);

	}

}
