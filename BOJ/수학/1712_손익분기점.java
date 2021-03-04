import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
* @since 2021. 2.
* @author Jin
* @see https://www.acmicpc.net/problem/1712
* @mem 14304kb
* @time 124ms
* @caution
*/

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringBuilder output = new StringBuilder();
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken()); // 고정
		int B = Integer.parseInt(st.nextToken()); // 가변
		int C = Integer.parseInt(st.nextToken()); // 판매가격
		int cnt = 0;

		if (B >= C) {
			System.out.println(-1);
		} else {
			System.out.println(A/(C-B)+1);
		}

		
	}

}