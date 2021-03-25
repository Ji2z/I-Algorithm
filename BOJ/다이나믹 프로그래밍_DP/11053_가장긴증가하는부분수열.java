import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
* @since 2021. 3. 25.
* @author Jin
* @see https://www.acmicpc.net/problem/11053
* @mem 12016kb
* @time 96ms
* @caution S2 초기화는 1
*/

public class 11053_가장긴증가하는부분수열 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int A = Integer.parseInt(br.readLine());
		
		int[] arr = new int[A];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < A; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int max = 0;
		int[] dp = new int[A];
		for (int i = 0; i < A; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if(arr[i] > arr[j] && dp[i] < dp[j]+1)
					dp[i] = dp[j]+1;
			}
			if(max < dp[i])
				max = dp[i];
		}
		
		System.out.println(max);
	}
}
