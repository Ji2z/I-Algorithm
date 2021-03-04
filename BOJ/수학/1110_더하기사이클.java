import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
* @since 2021. 2.
* @author Jin
* @see https://www.acmicpc.net/problem/1110
* @mem 14812kb
* @time 148ms
* @caution
*/

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		String num = br.readLine();
		if(num.length()==1) num = "0"+num;
		String answer = num;
		int cycle = 0;
		
		do {
			int a = Integer.parseInt(answer.substring(0, 1));
			int b = Integer.parseInt(answer.substring(1, 2));
			int c = (a+b)%10;
			answer = Integer.toString(10*b+c);
			if(answer.length()==1) answer = "0"+answer;
			cycle++;
		} while(!num.equals(answer));
		
		System.out.println(cycle);
	}

}
