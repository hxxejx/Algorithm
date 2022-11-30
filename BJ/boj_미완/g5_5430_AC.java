package boj_미완;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

/*
 * .addFirst(1) : 1을 덱의 앞에 추가 push_front X
 * .addLast(1) : 1을 덱의 뒤에 push_back X
 * .removeFirst() : 반환하고 제거 pop_front(없으면 -1)
 * .removeLast() : 제거 pop_back (없으면 -1)
 * .size(): 크기 size
 * .isEmpty() : 비어 있는지 확인 empty(비어 있으면 1, 아니면 0)
 * .peekFirst() : 첫번째 값 참조 front (없으면 -1)
 * .peekLast() : 마지막 값 참조 back(없으면 -1)
 * 
 * 1. 테스트 케이스 개수 T
 * 2. 수행할 함수 p = R(배열 뒤집기) D(첫번째 수 버리기)
 * 3. 배열의 원소 수 n
 * 4. 배열 정수
 */
public class g5_5430_AC {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		
		for(int tc = 0; tc < T; tc++) {
//			try {
				
				String pp = br.readLine();
				char[] p = pp.toCharArray(); //명령어 p 저장
				
				int n = Integer.parseInt(br.readLine()); //배열의 원소 개수
				
				Deque<Integer> arr1 = new LinkedList<>();
				Deque<Integer> arr2 = new LinkedList<>();
				Boolean arr = true;
				
				StringTokenizer st = new StringTokenizer(br.readLine(), "[,]");
				//System.out.println(st.nextToken());
				for(int i = 0; i < n; i++) {
					arr1.add(Integer.parseInt(st.nextToken()));
					System.out.println(arr1.peekLast());
				} //배열 저장
				
				for(int i = 0; i<p.length; i++) {
					switch(p[i]) {
					case 'R':
						if(arr == true) {
							arr = false;
							arr2.add(arr1.removeLast());
						}
						else {
							arr = true;
							arr1.add(arr2.removeLast());
						}
						break;
					case 'D':
						if(arr == true) {
							arr1.poll();
						}
						else {
							arr2.poll();
						}
						break;
					}
				}
				
				System.out.print("[");
				if(arr1.size()>=1 && arr == true) {
					for(int i = 0; i < arr1.size()-1; i++) {
						System.out.print(arr1.poll() + ",");
					}
				} else if(arr1.size()>=1 && arr == false) {
					for(int i = 0; i < arr2.size()-1; i++) {
						System.out.print(arr2.poll() + ",");
					}
				}
				System.out.println(arr1.poll() + "]");
//			} catch (NoSuchElementException e){
//				System.out.println("error");
//				continue outer;
//			}
		}
	}
}
