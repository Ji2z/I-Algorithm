import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
* @since 2021. 2.
* @author Jin
* @see https://www.acmicpc.net/problem/1316
* @mem 14604kb
* @time 132ms
* @caution
*/

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringBuilder output = new StringBuilder();
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());
		String s = null;
		int count[];
		int answer = T;

		for (int i = 0; i < T; i++) {
			s = br.readLine();
			count = new int[26];
			count[s.charAt(0)-97]++;
			for (int j = 1; j < s.length(); j++) {
				if (s.charAt(j) != s.charAt(j - 1)) {
					if (count[s.charAt(j) - 97] > 0) {
						answer--;
						break;
					} else
						count[s.charAt(j) - 97]++;
				}
			}
		}

		System.out.println(answer);
	}

}