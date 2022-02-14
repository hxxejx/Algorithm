import java.util.*;
import java.io.*;

/**
 * 입력
 * 1. 관리자 패스워드의 최댓값 N
 * 2. 해커가 사용한 패스워드의 개수 M
 * 3. 해커가 사용한 패스워드
 * 출력
 * 보안성이 가장 높은 패스워드의 보안성
 * 
 * >> 보안 척도는 이진법으로 표현한 두 패스워드의 서로 다른 자리 수
 * >> 해커가 시도했던 모든 패스워드와의 보안 척도 중 최솟값이 새 패스워드의 보안성
 * >> 가장 높은 보안성을 찾아야 됨
 * 
 * >> 서로 다른 자리의 개수가 많아야 보안성이 높음
 * >> 무조건 비어 있는 자리는 1로 채워야 함
 */
public class Algo3_광주_5반_허은지 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //표준입력
		
		int N = Integer.parseInt(br.readLine()); //관리자 패스워드 최댓값
		int M = Integer.parseInt(br.readLine()); //해커가 사용한 패스워드 개수
		
		int[] pw = new int[M]; //해커가 사용한 패스워드 저장
		StringTokenizer st = new StringTokenizer(br.readLine()); //한 줄을 받아 공백으로 구분
		for(int i = 0; i<M; i++) { //M만큼 반복해서 패스워드 저장
			pw[i] = Integer.parseInt(st.nextToken());
		}
		
		int max = Integer.MIN_VALUE; //최대 보안성
		
		
		outer: for(int i = pw[M-1]; i<=N; i++) {
			int min = Integer.MAX_VALUE; //보안성
			
			
			for(int j = 0; j<M; j++) {	
				int sec = 0; //보안 척도
				int newPw = i; //새로운 패스워드
				int hackPw = pw[j]; //해커가 쓴 패스워드
				if(hackPw==newPw) continue outer; //이미 사용된 수는 비교하지 않음
				while(newPw!=0) {//더 비교할 newPw의 이진수 없을 때 종료
					if(hackPw%2 != newPw%2) sec++; //이진법 자리수가 다르면 보안 척도 +1
					hackPw/=2; // 2진수를 구하기 위해 2로 나눠 저장
					newPw/=2; // 2진수를 구하기 위해 2로 나눠 저장
					//System.out.println(sec);
				}
				min = Math.min(min, sec); //보안 척도 제일 낮은 값을 보안성에 저장
			}
			max = Math.max(min, max); //보안성 가장 높은 값 구하기
		}
		
		System.out.println(max);
		
//		int num = pw[M-1]; //2진법 자리수
//		int bi = 1; //2진법 자리수
//		while(num==1) { //사용된 pw의 가장 큰 숫자를 받아서 2진법 자리수 구함
//			num/=2;
//			bi++;
//		}
//		
//		while(bi!=0) { //구한 2진법 자리수+1로 만들 수 있는 최댓값 구함
//			num += Math.pow(2, bi);
//			bi--;
//		}
//		
//		int sec = 0; //보안 척도
//		int min = 0; //보안성
//		
//		for(int i = num; i<num; i++) {
//			bi = 1;
//			int newPw = i; //새로운 패스워드
//			while(newPw==1) {//newPw가 1만 남으면 break;
//				newPw/=2; //2진법 자리수 구하기
//				bi++; //자리수 +1
//			}
//			newPw = i;//다시 정의
//			for(int j = 0; j<M; j++) {
//				int hackPw = pw[j]; //해커가 쓴 패스워드
//				while(hackPw!=1) {//더 비교할 hackPw가 없을 때 종료
//					if(hackPw%2 != newPw%2) sec++; //이진법 자리수가 다르면 보안 척도 +1
//					hackPw/=2; // 2진수를 구하기 위해 2로 나눠 저장
//					newPw/=2; // 2진수를 구하기 위해 2로 나눠 저장
//					bi--; //자리수 -1해서 차이 구하기
//				}
//			}
//			
//			sec += bi; //비교하지 않은 자리는 전부 다르므로 보안 척도 +
//			
//		}
		
	}//main
} //class
