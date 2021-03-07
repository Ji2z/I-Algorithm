import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
* @since 2021. 3. 7.
* @author Jin
* @see https://www.acmicpc.net/problem/1003
* @mem 11876kb
* @time 104ms
* @caution
*/

public class 1003_피보나치함수 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder("");

		int N = Integer.parseInt(br.readLine());
		
		for (int n = 0; n < N; n++) {
			int num = Integer.parseInt(br.readLine());
			
			int[] zero = new int[num+2];
			int[] one = new int[num+2];
			
			zero[0] = 1;
			zero[1] = 0;
			
			one[0] = 0;
			one[1] = 1;
			
			for (int i = 2; i <= num; i++) {
				zero[i] = zero[i-2]+zero[i-1];
				one[i] = one[i-2]+one[i-1];
			}
			
			output.append(String.format("%d %d\n", zero[num], one[num]));
		}
		
		System.out.println(output);
	}
}