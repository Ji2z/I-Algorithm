import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @since 2021. 3. 11.
 * @author Jin
 * @see https://www.acmicpc.net/problem/2577
 * @mem 11500kb
 * @time 76ms
 * @caution B2
 */

public class 2577_숫자의개수 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder("");
		
		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		
		int result = A*B*C;
		String s = Integer.toString(result);
		int[] count = new int[10];
		for (int i = 0; i < s.length(); i++) {
			count[Integer.parseInt(s.charAt(i)+"")]++;
		}
			
		for (int i = 0; i < 10; i++) {
			output.append(count[i]).append("\n");
		}
		System.out.println(output);
	}
}