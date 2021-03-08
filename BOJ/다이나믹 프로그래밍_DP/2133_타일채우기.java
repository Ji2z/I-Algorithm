import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @since 2021. 3. 8.
 * @author Jin
 * @see https://www.acmicpc.net/problem/2133
 * @mem 11488kb
 * @time 84ms
 * @caution
 */

public class 2133_타일채우기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); 
		
		int[] dp = new int[31];
		dp[2] = 3;
		dp[4] = 11;
		for (int i = 6; i <= N; i+=2) {
			dp[i] = dp[i-2]*dp[2]+2; // 6 => 4x2 + 2(특이케이스)
			for (int j = i-4; j >= 2; j-=2) {
				dp[i] += dp[j]*2; // 6 => 2*2(특이케이스 기본형 = 3*4사이즈)
			}
		}

		System.out.println(dp[N]);
	}
}