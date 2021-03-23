import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
* @since 2021. 3. 23.
* @author Jin
* @see https://www.acmicpc.net/problem/1149
* @mem 12068kb
* @time 88ms
* @caution S1
*/

public class 1149_RGB거리 {
	
	static int[][] dp;
	static int[][] color;
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		dp = new int[N][3];
		color = new int[N][3];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			color[i][0] = Integer.parseInt(st.nextToken());
			color[i][1] = Integer.parseInt(st.nextToken());
			color[i][2] = Integer.parseInt(st.nextToken());		
		}
		
		dp[0][0] = color[0][0];
		dp[0][1] = color[0][1];
		dp[0][2] = color[0][2];
		for (int i = 1; i < N; i++) {
			// R : G, B
			dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + color[i][0];
			
			// G : R, B
			dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + color[i][1];
			
			// B : R, G
			dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + color[i][2];
		}
		
		int min = Math.min(dp[N-1][0], dp[N-1][1]);
		min = Math.min(min, dp[N-1][2]);
		System.out.println(min);
	}
}
