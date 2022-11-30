package swea.d1;

import java.util.Scanner;
import java.io.FileInputStream;


class D1_2071
{
	public static void main(String args[]) throws Exception
	{

		System.setIn(new FileInputStream("res/input.txt"));

		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		

		for(int test_case = 1; test_case <= T; test_case++)
		{
			double sum = 0;
			double avg = 0;
			
			for(int i=0; i<10; i++) {
				int num = sc.nextInt();
				sum += num;
			}
			
			avg = sum/10;
			System.out.printf("#%d %.0f\n", test_case, avg);

		}
	}
}