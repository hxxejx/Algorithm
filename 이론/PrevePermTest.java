//현재부터 끝까지(처음부터 x) 속도도 빠름
//회사에서 출발해 회사로 돌아옴

import java.util.Arrays;

public class PrevePermTest {
	
	static int[] p = {3,1,2,4,5};
	static int N = p.length;
	static int count;
	
	public static void main(String[] args) {
		
		do {
			count++;
			System.out.println(Arrays.toString(p));
		}while(preve(N-1));
		
		System.out.println(count);
		

	}

	private static boolean preve(int size) {
		int i = size;
		while(i>0 && p[i-1]<=p[i]) i--;
		if(i==0) return false;
		
		int j=size;
		while(i<=j && p[i-1]<=p[j]) j--;
		int tmp = p[i-1];
		p[i-1] = p[j];
		p[j] = tmp;
		
		int k = size;
		while(i<=k) {
			tmp = p[i];
			p[i] = p[k];
			p[k] = tmp;
			i++;
			k--;
		}
		
		return true;
	}

}
