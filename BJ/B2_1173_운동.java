import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int count = 0;
        int time = 0;
        int current = m;

        while(count<N) {

            if(current+T <= M) {
                count++;
                time++;
                current += T;
            } else {
                if((current - R)< m) {
                    time++;
                    current = m ;
                } else {
                    time++;
                    current -= R;
                }
            }            

            if(current + T > M && current == m) {
                System.out.println(-1);
                return;
            }

        }

        System.out.println(time);

    }

}

 

