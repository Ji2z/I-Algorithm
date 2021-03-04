import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
* @since 2021. 2. 25.
* @author Jin
* @see https://www.acmicpc.net/problem/8958
* @mem 11832kb
* @time 84ms
* @caution
*/

public class OX퀴즈_8958 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			int score = 0;
			int sumScore = 0;
			for (int j = 0; j < s.length(); j++) {
				if(s.charAt(j)=='O') {
					score++;
					sumScore += score;
				}else{
					score = 0;
				}
			}
			output.append(sumScore).append("\n");
		}
		
		System.out.println(output);
	}	
}
