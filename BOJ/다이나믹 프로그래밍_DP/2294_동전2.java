import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
* @since 2021. 3. 25.
* @author Jin
* @see https://www.acmicpc.net/problem/2294
* @mem 12136kb
* @time 116ms
* @caution S1 모든 과정에서 min연산을..
*/

public class 2294_동전2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int[] dp = new int[k+1];
		Arrays.fill(dp, 10001);
		for (int i = 1; i <= k; i++) {
			for (int j = 0; j < n; j++) {
				if(i%arr[j] == 0)
					dp[i] = Math.min(dp[i], i/arr[j]);
				if(i-arr[j]>=0)
					dp[i] = Math.min(dp[i], dp[i-arr[j]]+1);
			}	
		}
		//System.out.println(Arrays.toString(dp));
		if(dp[k]==10001)
			System.out.println(-1);
		else
			System.out.println(dp[k]);
	}

}
