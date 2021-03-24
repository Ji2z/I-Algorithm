import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
* @since 2021. 3. 24.
* @author Jin
* @see https://www.acmicpc.net/problem/2579
* @mem 11444kb
* @time 84ms
* @caution S3: dp는 인덱스 초기화 조심!!
*/

public class 2579_계단오르기 {
	
	static int N;
	static int[] dan;
	static int[] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		dan = new int[N+1];
		dp = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			dan[i] = Integer.parseInt(br.readLine());
		}

		dp[0] = 0;
		dp[1] = dan[1];
		if(N>=2)
			dp[2] = dan[1] + dan[2];
		
		//dp[3] = Math.max(dan[1], dan[2]) + dan[3];		
		//dp[4] = Math.max(dp[2], dp[1]+dan[3])+dan[4];
		for (int i = 3; i <= N; i++) {
			dp[i] = Math.max(dp[i-2], dp[i-3]+dan[i-1])+dan[i];
		}
		
		System.out.println(dp[N]);
		//System.out.println(Arrays.toString(dp));
	}
}
