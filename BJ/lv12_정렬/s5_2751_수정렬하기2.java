package lv12_정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
 * 1. 첫째줄에 개수 N
 * 2. N개의 숫자
 * 3. 오름차순으로 출력
 * 
 * >> arr써서 정렬 => 시간 초과
 * >>  => 시간 초과
 * >> merge sort => Collections.sort => 시간 초과 ==>> stringbuilder 쓰면 시간 초과 안 남
 */
public class s5_2751_수정렬하기2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer> num = new ArrayList<Integer>();
		
		for(int i = 0; i < N; i++) {
			num.add(Integer.parseInt(br.readLine()));
		}
		
		Collections.sort(num);
		
		for(int value : num) {
			sb.append(value).append('\n');
		}
		System.out.println(sb);
	}
	
//	arr
//	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		
//		int N = Integer.parseInt(br.readLine());
//		int[] arr = new int[N];
//		
//		for(int i = 0; i < N; i++) {
//			arr[i] = Integer.parseInt(br.readLine());
//		}
//		
//		Arrays.sort(arr);
//		
//		for(int i = 0; i < N; i++) {
//			System.out.println(arr[i]);
//		}
//	}
	
//	sort
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		Scanner sc = new Scanner(System.in);
//		int N = sc.nextInt();
//		int[] num = new int[N];
//		
//		for(int i = 0; i<N; i++) {
//			num[i] = sc.nextInt();
//		} 
//		
//		for(int i = 0; i < N; i++) {
//			for(int j = i+1; j < N; j++) {
//				if(num[i] > num[j]) {
//					int tmp = num[i];
//					num[i] = num[j];
//					num[j] = tmp;
//				}
//			}
//		}
//		for(int i = 0; i < N; i++) {
//			System.out.println(num[i]);
//		}
//	}
}
