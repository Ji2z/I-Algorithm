import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
* @since 2021. 2.
* @author Jin
* @see https://www.acmicpc.net/problem/2908
* @mem 14504kb
* @time 132ms
* @caution
*/

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		String s = br.readLine();
		st = new StringTokenizer(s);
		
		StringBuilder sb = new StringBuilder(st.nextToken());
		StringBuilder sb2 = new StringBuilder(st.nextToken());

		int a = Integer.parseInt(sb.reverse().toString());
		int b = Integer.parseInt(sb2.reverse().toString());
		
		if(a>b) System.out.println(a);
		else System.out.println(b);
	}

	
}
