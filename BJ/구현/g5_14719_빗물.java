package 구현;

import java.io.*;
import java.util.*;

/*
 * 입력
 * 1. 세로 H 가로 W
 * 2. 블록이 쌓인 높이 H
 * 출력
 * 1. 고이는 빗물의 총량/고이지 않을 경우 0
 */
public class g5_14719_빗물 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[W];
		
		// 가장 높은 기둥
		int max = 0;
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < W; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, arr[i]);
		}
		
		// 현재 기둥의 높이(빗물의 기준이 된다)
		int height = 0;
		// 모인 빗물(웅덩이 한 개)
		int tmp = 0;
		// 모인 빗물들의 합
		int sum = 0;
		
		// 왼쪽부터
		for (int i = 0; i < W; i++) {
			// 현재 기둥의 높이보다 낮은 기둥에서는 빗물이 고인다
			if(height > arr[i]) tmp += height-arr[i];
			// 현재 기둥보다 높거나 같은 높이의 기둥을 만난다면 웅덩이에 고인 빗물의 값을 더해 준다
			// 다음 웅덩이도 구해야 하므로 웅덩이의 값을 0으로 초기화
			// 현재 기둥의 값을 다음 기둥의 값으로 초기화
			else {
				sum += tmp;
				height = arr[i];
				tmp = 0;
			}
		}
		
		height = 0;
		tmp = 0;
		
		// 오른쪽부터
		// 왼쪽부터 구하는 경우, 가장 높은 기둥 중 가장 오른쪽에 있는 기둥 이후로는 빗물의 값이 더해지지 않음
		// 위의 식에서 구하지 못한 빗물의 값(가장 높은 기둥 중 가장 오른쪽에 있는 이후의 빗물의 값)을 오른쪽부터 구함
		for (int i = W-1; i >= 0; i--) {
			if(height > arr[i]) tmp += height-arr[i];
			else {
				sum += tmp;
				height = arr[i];
				tmp = 0;
			}
			
			// 가장 높은 기둥 중 가장 오른쪽에 있는 기둥을 만나면 break
			// 오른쪽부터 시작했기 때문에 가장 먼저 만나는 높은 기둥이 가장 오른쪽에 있음
			if(arr[i]==max) break;
		}

		System.out.println(sum);
		
	}

}
