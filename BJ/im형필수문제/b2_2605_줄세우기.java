package im형필수문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

/*
 * 1. 학생의 수 N
 * 2. 줄을 선 차례대로 학생들이 뽑은 숫자
 * 3. 뽑은 수만큼 앞자리로 가서 줄을 선다
 * 
 * >> stack 사용 XX >> Deque 사용
 * >> 뽑은 숫자만큼 pop한 뒤 다시 넣기
 */
public class b2_2605_줄세우기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Deque<Integer> deq = new LinkedList<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(num==0) deq.addLast(i);
			else {
				for(int j = 0; j<num; j++) {
					deq.addFirst(deq.pollLast());
				} //뽑은 번호만큼 poll
				deq.addLast(i); //사람 넣고
				for(int j = 0; j<num; j++) {
					deq.addLast(deq.pollFirst());
				} //원상복귀
			}
		}
		for(int i = 0; i < N; i++) {
			System.out.print(deq.poll() + " ");
		}
	}
}
