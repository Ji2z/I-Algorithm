import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
* @since 2021. 2. 23.
* @author Jin
* @see https://www.acmicpc.net/problem/2999
* @mem 11492kb
* @time 76ms
* @caution
*/

public class 비밀_이메일_2999 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();

		String s = br.readLine();
		int len = s.length();
		int R = 0;
		for (int i = 1; i <= len/i; i++) {
			if(len%i==0) 
				R = i;
		}
		int C = len/R;
		
		char[][] msg = new char[R][C];
		int index = 0;
		for (int j = 0; j < C; j++) {
			for (int i = 0; i < R; i++) {
				msg[i][j] = s.charAt(index++);
			}
		}
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				output.append(msg[i][j]);
			}
		}
		System.out.println(output);
	}	
}
