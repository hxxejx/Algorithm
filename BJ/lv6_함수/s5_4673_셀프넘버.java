package lv6_함수;

/*
 * 1. 10000짜리 배열 생성
 * 2. 1부터 시작해서 만들어지는 수열 d(n)의 위치에 1 넣음
 * 3. 10000까지 돌고 나서 값이 0인 배열만 출력
 */
public class s5_4673_셀프넘버 {

	public static void main(String[] args) {
		int[] arr = new int[10000]; // 1
		
		for(int i = 0; i<10000; i++) {
			if(arr[i]==0) { //생성자가 없을 때
				for(int j=i+1; j<=10000; j++) {
					int d = j + j%10 + (j/10)%10 + (j/100)%10 + (j/1000)%10; //한자리씩 더하기
					if(d<=10000) arr[d-1] = 1; //d가 10000 이하일 경우에만 위치에 넣음
				}
			}
		} // 2
		
		// 3
		for(int i = 0; i<10000; i++) {
			if(arr[i]==0) System.out.println(i+1); //배열의 값이 0일 때 배열 위치 +1 출력
		}
	}
}
