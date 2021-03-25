import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
* @since 2021. 3. 25.
* @author Jin
* @see https://www.acmicpc.net/problem/1106
* @mem 11672kb
* @time 128ms
* @caution S2 초기화 값을 잘 계산하기...
*/

public class 1106_호텔 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int C = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int[] money = new int[N+1];
		int[] person = new int[N+1];
		//int maxp = 0;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			money[i] = Integer.parseInt(st.nextToken());
			person[i] = Integer.parseInt(st.nextToken());
			//maxp = Math.max(maxp, person[i]);
		}
		
		int[] dp = new int[2001];
		Arrays.fill(dp, 100001);
		
		for (int i = 1; i <= 2000; i++) {
			for (int j = 1; j <= N; j++) {
				if(i%person[j] == 0)
					dp[i] = Math.min(dp[i], (i/person[j])*money[j]);
				if(i-person[j]>=0)
					dp[i] = Math.min(dp[i], dp[i-person[j]]+money[j]);
			}
		}
		
		int answer = dp[C];
		for (int i = C+1; i < 2001; i++) {
			answer = Math.min(answer, dp[i]);
		}
		//System.out.println(Arrays.toString(dp));
		System.out.println(answer);
	}
}
