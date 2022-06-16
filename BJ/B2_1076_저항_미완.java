package 문제풀이;

import java.io.*;
import java.util.*;

public class B2_1076_저항_미완 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String[] color = new String[3];
		
		color[0] = br.readLine();
		color[1] = br.readLine();
		color[2] = br.readLine();
		
		if(color[0].equals("brown")) sb.append("1");
		else if(color[0].equals("red")) sb.append("2");
		else if(color[0].equals("orange")) sb.append("3");
		else if(color[0].equals("yellow")) sb.append("4");
		else if(color[0].equals("green")) sb.append("5");
		else if(color[0].equals("blue")) sb.append("6");
		else if(color[0].equals("violet")) sb.append("7");
		else if(color[0].equals("grey")) sb.append("8");
		else if(color[0].equals("white")) sb.append("9");
		
		if(color[1].equals("black")) sb.append("0");
		else if(color[1].equals("brown")) sb.append("1");
		else if(color[1].equals("red")) sb.append("2");
		else if(color[1].equals("orange")) sb.append("3");
		else if(color[1].equals("yellow")) sb.append("4");
		else if(color[1].equals("green")) sb.append("5");
		else if(color[1].equals("blue")) sb.append("6");
		else if(color[1].equals("violet")) sb.append("7");
		else if(color[1].equals("grey")) sb.append("8");
		else if(color[1].equals("white")) sb.append("9");
		
		
		if(color[2].equals("brown")) sb.append("0");
		else if(color[2].equals("red")) sb.append("00");
		else if(color[2].equals("orange")) sb.append("000");
		else if(color[2].equals("yellow")) sb.append("0000");
		else if(color[2].equals("green")) sb.append("00000");
		else if(color[2].equals("blue")) sb.append("000000");
		else if(color[2].equals("violet")) sb.append("0000000");
		else if(color[2].equals("grey")) sb.append("00000000");
		else if(color[2].equals("white")) sb.append("000000000");
		
		System.out.println(sb);
		
	}

}
