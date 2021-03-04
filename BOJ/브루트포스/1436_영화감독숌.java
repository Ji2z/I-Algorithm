import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @since 2021. 2. 7.
 * @author
 * @see https://www.acmicpc.net/problem/1436
 * @mem 84848kb
 * @time 320ms
 * @caution
 */

public class 1436_영화감독숌 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int num = 666;
		int cnt = 0;

		while (true) {
			String s = Integer.toString(num);
			if(s.contains("666")) cnt++;
			if(cnt == N) break;
			num++;
		}

		System.out.println(num);
	}
}
