import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
* @since 2021. 2. 5.
* @author Jin
* @see https://www.acmicpc.net/problem/11024
* @mem 14980kb
* @time 152ms
* @caution
*/

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		// StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			String[] num = br.readLine().split(" ");
			int sum = 0;
			for (int i = 0; i < num.length; i++) {
				sum += Integer.parseInt(num[i]);
			}
			output.append(sum).append("\n");
		}

		System.out.println(output);
	}
}