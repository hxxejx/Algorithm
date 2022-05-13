import java.util.Arrays;

public class PermTest3 {

	static int[] p = {1,2,3,4,5};
	static int N = p.length;
	static int count;
	static int R=3;
	static int[] nums;
	
	public static void main(String[] args) {
		nums = new int[R];
		perm(0,0);
		System.out.println(count);

	}
	private static void perm(int cnt, int flag) {
		if(cnt==R) {
			System.out.println(Arrays.toString(nums));
			count++;
			return;
		}
		
		// 1<<N = 2^N
		for (int i = 0; i < N; i++) {
			if((flag &(1<<i))!=0) continue;
			nums[cnt] = p[i];
			perm(cnt+1, (flag |(1<<i)));
		}
		
	}

}
