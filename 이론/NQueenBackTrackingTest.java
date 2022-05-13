import java.util.*;
import java.io.*;

/*
 * >> 백트래킹(가지치기)
 * >> 모든 가능한 경우의 수 중에서 특정한 조건을 만족하는 경우만 살펴보는 것
 * >> 답이 될 만한지 판단하고 그렇지 않으면 그 부분까지 탐색하는 것을 하지 않고 가지치기
 * >> DFS로 모든 경우의 수를 탐색하는 과정에서, 조건으로 답이 절대로 될 수 없는 상황을 정의하여 체크
 * >> 그러한 상황일 경우에는 탐색을 중지시킨 뒤 그 이전으로 돌아가서 다른 경우 탐색
 */
public class NQueenBackTrackingTest {

	static int N, ans;
	static int col[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		col = new int[N+1];
		
		setQueen(1);
		System.out.println(ans);

	}

	private static void setQueen(int rowNo) { // rowNo: 퀸을 두어야 하는 현재 행
		//if(!isAvailable(rowNo-1)) return; //직전까지의 상황이 유망하지 않으면 return
		
		// 기본파트 : 퀸을 모두 놓았다면
		if(rowNo>N) {
			ans++;
			return;
		}
		
		// 1열부터 - n열까지 퀸을 놓는 시도
		for(int i = 1; i<=N; i++) {
			col[rowNo] = i; 
			if(isAvailable(rowNo)) {
				setQueen(rowNo+1);
			}
		}
		
	}
	
	private static boolean isAvailable (int rowNo) { // rowNo: 놓아진 마지막 퀸
		
		// 1열부터 - n열까지 퀸을 놓는 시도
		for(int i = 1; i < rowNo; i++) {
			if(col[rowNo]==col[i] || rowNo-i == Math.abs(col[rowNo]-col[i])) return false;
		}		//행이 같을 때			대각선(행과 열의 변화량이 같을 때)
		return true;
	}

}
