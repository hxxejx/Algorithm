import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(br.readLine());

		int time = A*60 + B + C;
		A = time/60;
		B = time%60;

		if (A>=24) A = A-24;
		
		System.out.println(A + " "+ B);
	}

}
