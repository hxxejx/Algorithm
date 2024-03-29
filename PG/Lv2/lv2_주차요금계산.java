package Lv2;

import java.io.*;
import java.util.*;

public class 주차요금계산 {

	public static void main(String[] args) throws Exception {
		int[] fees = {1, 461, 1, 10};
		String[] records = {"00:00 1234 IN"};
		int[] answer = {};
		
		answer = solution(fees, records);
		
		for (int i = 0; i < answer.length; i++) {
			System.out.println(answer[i]);
		}
	}

	private static int[] solution(int[] fees, String[] records) {
		int[] answer = {};
		
		// 차량 번호를 입력받을 set
		Set<Integer> set = new HashSet<>();
		
		// times라는 배열을 선언해 인덱스를 차량 번호로 한다
		// 차량 번호는 0000부터 9999까지 있으므로 배열의 크기를 10000으로 해 준다
		int[] times = new int[10000];
		for (int i = 0; i < records.length; i++) {
			StringTokenizer st = new StringTokenizer(records[i]);
			
			// StringTokenizer를 이용해 시각, 차량 번호, in&out을 받는다
			String time[] = st.nextToken().split(":");
			int num = Integer.parseInt(st.nextToken());
			String inout = st.nextToken();
			
			// 차량 번호를 입력받는다
			set.add(num);
			
			// 차량의 시각을 분으로 바꾼다
			int minute = Integer.parseInt(time[0])*60 + Integer.parseInt(time[1]);
			
			// 내역이 in이라면 해당 분을 빼 주고, 내역이 out이라면 해당 분을 더해 준다
			// 출차 시간에서 입차 시간을 빼야 주차 시간이 나온다
			if(inout.equals("IN")) times[num] -= minute;
			else times[num] += minute;
		}

		// 차량 번호를 정렬하기 위해 list로 옮겨 준 뒤 정렬한다
		List<Integer> list = new ArrayList<>(set);
		Collections.sort(list);
		
		// 차량 번호의 개수만큼 답을 받는다
		answer = new int[list.size()];
		
		for (int i = 0; i < list.size(); i++) {
			// 차량 번호를 index로 설정한 뒤, 해당 시간이 음수라면(마지막에 출차가 찍히지 않았다면) 23:59를 더해 준다
			int idx = list.get(i);
			if(times[idx] <= 0) times[idx] += 1439;
			// 기본 요금
			answer[i] = fees[1];
			// 기본 시간을 초과할 경우 그것을 뺀 만큼 단위 요금이 추가된다
			if(times[idx] > fees[0]) answer[i] += Math.ceil((double)(times[idx] - fees[0])/fees[2])*fees[3];

		}
		
        return answer;
	}

}
