import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
* @since 2021. 3. 24.
* @author Jin
* @see https://www.acmicpc.net/problem/12865
* @mem 51240kb
* @time 144ms
* @caution G5
*/

public class 평범한배낭 {
	
	static int N, K;
	static Good[] goods;
	
	// dp[i][k] = i번째 상품까지 고려했을 때 k 무게에 담을 수 있는 최대의 가치
	static int[][] dp;
	static class Good{
		int w;
		int v;
		public Good(int w, int v) {
			super();
			this.w = w;
			this.v = v;
		}
		@Override
		public String toString() {
			return "Good [w=" + w + ", v=" + v + "]";
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		goods = new Good[N+1]; // 0번 상품(하나도 선택하지 않은 경우)고려
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int w  = Integer.parseInt(st.nextToken());
			int v  = Integer.parseInt(st.nextToken());
			goods[i] = new Good(w,v);
		}
		
		dp = new int[N+1][K+1];
		// 기저조건에 대한 처리 : {}, 0kg --> 어차피 0
		for (int i = 1; i <= N; i++) {
			// 해당 상품까지 고려했을 때 무게를 증가시켜가며 최대 만족도를 적용해보자.
			for (int k = 0; k <= K; k++) {
				// 못넣는 경우
				if(goods[i].w > k) {
					// i를 고려하지 않았을 때 k 무게에서의 최선이 최선
					dp[i][k] = dp[i-1][k];
				}
				// 넣을 수 있을 경우
				else {
					//안넣은 경우
					int a = dp[i-1][k];
					// 넣는 경우 - 현재 상품을 넣을 수 있는 공간 확보 필요
					int b = dp[i-1][k-goods[i].w] + goods[i].v;
					dp[i][k] = Math.max(a, b);
				}
			}
		}// dp 처리 완료
//		for(int[] row : dp)
//			System.out.println(Arrays.toString(row));
		
		System.out.println(dp[N][K]);
	}
	
}
