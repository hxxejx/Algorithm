import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class S3_2407_조합 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        m = Math.min(n-m, m);
        
        BigInteger ans = BigInteger.ONE;
        for (int i = 1; i <= m; i++) {
			ans = ans.multiply(new BigInteger(String.valueOf(n - i + 1))).divide(new BigInteger(String.valueOf(i)));
		}
        
        System.out.println(ans);
    }

}
