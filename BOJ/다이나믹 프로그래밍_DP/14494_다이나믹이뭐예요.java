import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @since 2021. 3. 8.
 * @author Jin
 * @see https://www.acmicpc.net/problem/14494
 * @mem 19580kb
 * @time 112ms
 * @caution
 */

public class 14494_다이나믹이뭐예요 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");

		int n = Integer.parseInt(st.nextToken()); 
		int m = Integer.parseInt(st.nextToken()); 
		
		long[][] dp = new long[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(i==0||j==0) dp[i][j] = 1;
				else dp[i][j] = dp[i-1][j]%1000000007+dp[i][j-1]%1000000007+dp[i-1][j-1]%1000000007;
			}
		}

		System.out.println(dp[n-1][m-1]%1000000007);
	}
}