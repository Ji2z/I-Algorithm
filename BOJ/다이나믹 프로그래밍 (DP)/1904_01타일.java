import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
* @since 2021. 3. 7.
* @author Jin
* @see https://www.acmicpc.net/problem/1904
* @mem 15468kb
* @time 104ms
* @caution
*/

public class 1904_01타일 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringBuilder output = new StringBuilder("");
		//StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(br.readLine());
		
		int[] dp = new int[N+2];
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		
		for (int i = 3; i <= N; i++) {
			dp[i] = dp[i-1] + dp[i-2];
			dp[i] %= 15746;
		}
		
		System.out.println(dp[N]);
	}
}