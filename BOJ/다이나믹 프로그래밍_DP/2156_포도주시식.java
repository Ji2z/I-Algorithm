import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
* @since 2021. 3. 24.
* @author Jin
* @see https://www.acmicpc.net/problem/2156
* @mem 12744kb
* @time 108ms
* @caution S1 : 안먹고 지나가면.. 값을 그대로 끌고 가는 것......
*/

public class 2156_포도주시식 {
	static int N;
	static int[] grape;
	static int[] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		grape = new int[N+1];
		dp = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			grape[i] = Integer.parseInt(br.readLine());
		}

		dp[0] = 0;
		dp[1] = grape[1];
		if(N>=2)
			dp[2] = grape[1] + grape[2];
		
		for (int i = 3; i <= N; i++) {
			dp[i] = Math.max(dp[i-2], dp[i-3]+grape[i-1])+grape[i];
			dp[i] = Math.max(dp[i], dp[i-1]);

			// 0 100 100 1 1 100 100
			// 0 100 200             
		}
		
		//System.out.println(Arrays.toString(dp));
		Arrays.sort(dp);
		System.out.println(dp[N]);
	}
}
