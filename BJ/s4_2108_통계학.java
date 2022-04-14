package lv12_정렬;

import java.util.*;
import java.io.*;

/*
 * 1. 첫째줄에 수의 개수 N
 * 2. N개의 정수
 * 
 * >> 산술평균: 평균 >> String.format 사용해서 반올림
 * >> 중앙값: 오름차순 정렬한 뒤 중앙에 위치하는 값 >> 오름차순 정렬한 뒤 가운데값 뽑기
 * >> 최빈값: 가장 많이 나타나는 값 >> 배열에 넣어서 세기
 * >> 범위: 최댓값과 최솟값의 차이 >> 오름차순 정렬한 뒤 제일 큰 값에서 제일 작은 값 빼기
 */
public class s4_2108_통계학 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N];
		int[][] mode = new int[2][4001]; //0일때 양수, 1일때 음수(최빈값 셀 때 쓰기)
		
		double sum = 0;
		
		for(int i = 0; i<N; i++) {
			int num = Integer.parseInt(br.readLine());
			
			sum += num; //산술평균 구할 때 쓰기
			nums[i] = num; //중앙값, 범위 구할때 쓰기
			
			if(num>=0) mode[0][num]++; //num이 양수면 [0] 배열 해당 숫자 인덱스에 빈도 저장
			else mode[1][(-1)*num]++; //num이 음수면 [1] 배열 해당 숫자 절대값 인덱스에 빈도 저장
		}
		
		int max = 0;
		int maxResult = 0;
		boolean b = false;
		
		//빈도수
		for(int i = 4000; i >= 0; i--) { //음수는 절대값이 클수록 작기 때문에 큰 수부터 돌리기
			if(max < mode[1][i]) { //max값보다 빈도수 높으면
				max = mode[1][i]; //max에 저장
				maxResult = (-1)*i; //인덱스를 절대값으로 저장했기 때문에 다시 -1 곱해줌
				b = true;
			} else if(b==true && max == mode[1][i]) { //같은 빈도수가 있으면 두번째 값 저장
				maxResult = (-1)*i;
				b = false; //세번째 값부터 저장할 수 없게 boolean false로 바꿈
			}
		}
		
		for(int i = 0; i < 4001; i++) { //양수 최빈값 구하기
			if(max < mode[0][i]) {
				max = mode[0][i];
				maxResult = i;
				b = true;
			} else if(b==true && max == mode[0][i]) {
				maxResult = i;
				b = false;
			}
		}
		
		//중앙값, 범위 구하기 위해 오름차순 정렬
		Arrays.sort(nums);
		
		sb.append(String.format("%.0f",sum/N)).append("\n").append(nums[N/2]).append("\n").append(maxResult).append("\n").append(nums[N-1]-nums[0]);
		System.out.println(sb);
	}
}
