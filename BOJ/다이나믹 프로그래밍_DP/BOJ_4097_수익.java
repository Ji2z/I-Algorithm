import java.io.*;
import java.util.*;

/**
* @since 2021. 6. 8.
* @author Jin
* @see https://www.acmicpc.net/problem/4097
* @mem 85444kb
* @time 420ms
* @caution S2
*/

public class BOJ_4097_수익 {

	static int N, answer;
	static int[] arr, dp;
	static BufferedReader br;
	static StringBuilder output;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		output = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		while(N != 0) {
			arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(br.readLine());
			}
			dp = new int[N];
			dp[0] = arr[0];
			answer = dp[0];
			for (int i = 1; i < N; i++) {
				dp[i] = Math.max(dp[i-1]+arr[i], arr[i]);
				answer = Math.max(answer, dp[i]);
			}
			N = Integer.parseInt(br.readLine());
			output.append(answer).append("\n");
		}
		
		System.out.println(output);
	}
	
}
