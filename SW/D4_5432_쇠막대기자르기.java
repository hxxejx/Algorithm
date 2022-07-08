import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 * 1. 첫번째 줄 T 테스트케이스
 * 2. 공백없이 괄호
 * 3. 괄호 두개째부터 막대 하나씩 생김
 * 4. 출력 "#" + tc + " " + result
 * 
 * >> stack을 사용
 * >> (면 쌓기 )면 삭제
 * >> stack을 쌓은 다음 ()가 나오면 스택의 크기만큼 쇠막대기 생김 or ))가 나오면 +1개만큼 쇠막대기 생김
 */
public class D4_5432_쇠막대기자르기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		File file = new File("D4_5432_쇠막대기자르기.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());	
		Stack<Character> stack = new Stack<>();
		
		for(int tc = 1; tc <= T; tc++) {
			int result = 0; 
			char[] c = br.readLine().toCharArray();	
			
			for(int i = 0; i < c.length; i++) {
	
				switch(c[i]) {
				case('('):
					stack.push(c[i]);
					break;
				case(')'):
					if(c[i-1]=='(') {stack.pop(); result += stack.size();} //()모양일 때는 레이저 >> size만큼 더하기
					else {stack.pop(); result++;} // 레이저가 아닐 때는 1만 더하기
					break;
				}
			}
			System.out.println("#" + tc + " " + result);
		}
	}
}
