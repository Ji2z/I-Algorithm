import java.io.*;
import java.util.*;

/**
* @since 2021. 6. 13.
* @author Jin
* @see https://www.acmicpc.net/problem/9095
* @mem 11436kb
* @time 76ms
* @caution S3
*/

public class BOJ_9095_1,2,3더하기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder("");
		StringTokenizer st = null;
		
		int[] dp = new int[11];
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		for (int i = 4; i < dp.length; i++) {
			dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
		}
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			output.append(dp[N]).append("\n");
		}

		System.out.println(output);
	}

}
