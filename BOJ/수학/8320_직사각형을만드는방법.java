import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
* @since 2021. 2. 26.
* @author Jin
* @see https://www.acmicpc.net/problem/8320
* @mem 11708kb
* @time 120ms
* @caution
*/

public class 직사각형을_만드는_방법_8320 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int answer = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = i; j <= n; j++) {
				if(i*j <= n) answer++;
			}
		}
		
		System.out.println(answer);
	}	
}
