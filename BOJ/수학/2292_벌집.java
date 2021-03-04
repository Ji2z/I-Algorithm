import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
* @since 2021. 3. 4.
* @author Jin
* @see https://www.acmicpc.net/problem/2292
* @mem 14688kb
* @time 136ms
* @caution
*/

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringBuilder output = new StringBuilder();
		StringTokenizer st = null;

		int num = Integer.parseInt(br.readLine());
		int answer = 1;
		int sum = 2;

		if (num == 1) System.out.println(1);
		else {
			while (num>=sum) {
				sum += 6*(answer++);
			}
			System.out.println(answer);
		}
	}

}
