import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
* @since 2021. 2. 26.
* @author Jin
* @see https://www.acmicpc.net/problem/2851
* @mem 11408kb
* @time 80ms
* @caution
*/

public class 슈퍼마리오_2851 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int answer = 0;
		int temp = 0;
		for (int i = 0; i < 10; i++) {
			temp = answer;
			answer += Integer.parseInt(br.readLine());
			if(answer >= 100) {
				if(100 - temp < answer - 100) answer = temp;
				break;
			}
		}
		
		System.out.println(answer);
	}	
}
