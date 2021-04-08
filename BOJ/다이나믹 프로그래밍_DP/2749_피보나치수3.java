import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @since 2021. 4. 8.
 * @author Jin
 * @see https://www.acmicpc.net/problem/2749
 * @mem 23544kb
 * @time 120ms
 * @caution G2 피사노 주기를 이용한 풀이 => n번째 피보나치수를 1000이상의 10의 거듭제곱 수로 나누면 주기가 반복된다.
 */

public class 2749_피보나치수3 {

	static long N;
	static long[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Long.parseLong(br.readLine());
		int mod = 1000000;
		int p = mod/10*15;
		dp = new long[p+1];

		dp[1] = 1;
		for (int i = 2; i <= p; i++) {
			dp[i] = dp[i-1] + dp[i-2];
			dp[i] %= mod;
		}
		
		System.out.println(dp[(int)(N%p)]);
	}

}