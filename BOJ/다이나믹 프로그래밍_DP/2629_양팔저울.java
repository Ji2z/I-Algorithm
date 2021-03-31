import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @since 2021. 3. 31.
 * @author Jin
 * @see https://www.acmicpc.net/problem/2629
 * @mem 12752kb
 * @time 80ms
 * @caution G2
 */

public class 2629_양팔저울 {

	static int N;
	static int[] weights;

	static int ball;

	static boolean[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder("");
		StringTokenizer st = null;


		// 추 입력
		N = Integer.parseInt(br.readLine());
		dp = new boolean[N + 1][15001];
		st = new StringTokenizer(br.readLine(), " ");
		weights = new int[N];
		int max = 0;
		for (int i = 0; i < N; i++) {
			int w = Integer.parseInt(st.nextToken());
			weights[i] = w;
			max += w;
		}

		check(0, 0);

		// 구슬 입력
		ball = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < ball; i++) {
			int b = Integer.parseInt(st.nextToken());
			if (b > max) {
				output.append("N").append(" ");
			} else {
				if (dp[N][b])
					output.append("Y").append(" ");
				else
					output.append("N").append(" ");
			}
		}

		System.out.println(output);

	}

	static void check(int idx, int sum) {
		if(dp[idx][sum]) return;
		dp[idx][sum] = true;
		if (idx == N)
			return;
		check(idx + 1, sum + weights[idx]); // 무게를 더했을 때
		check(idx + 1, Math.abs(sum - weights[idx])); // 무게의 차이를 구할 때
		check(idx + 1, sum); // 현재 무게를 더하지 않고 다음 무게로 넘어갈 때
	}

}