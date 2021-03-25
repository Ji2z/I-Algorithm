import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @since 2021. 3. 25.
 * @author Jin
 * @see https://www.acmicpc.net/problem/12738
 * @mem 169484kb
 * @time 544ms
 * @caution G2 LIS
 */

public class 12738_가장긴증가하는부분수열3 {
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
			int temp = Arrays.binarySearch(dp, 0, max, arr[i]);
			if (temp < 0) {
				temp = Math.abs(temp) - 1;
				dp[temp] = arr[i];
			}

			if (temp == max)
				++max;
		}

		System.out.println(max);
	}
}
