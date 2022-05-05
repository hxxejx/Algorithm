package 구현;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int H = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		if(M-45>=0) M -= 45;
		else {
			M += 15;
			if(H-1<0) H = 23;
			else H--;
		}
		
		System.out.println(H + " " + M);
	}

}
