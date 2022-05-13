
public class ForCombi {

	static int[] p = {1,2,3,4,5};
	static int N = p.length;
	static int count;
	public static void main(String[] args) {
		
		//nC3
		for (int i = 0; i < N; i++) {
			for (int j = i+1; j < N; j++) {
				for (int k = j+1; k < N; k++) {
					System.out.println(p[i] + " " + p[j] + " " + p[k]);
					count++;
				}
			}
			
		}
		System.out.println(count);
	}

}
