import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @since 2021. 3. 19.
 * @author Jin
 * @see https://www.acmicpc.net/problem/1743
 * @mem 13432kb
 * @time 116ms
 * @caution S1
 */

public class 1743_음식물피하기 {

	static int N, M, K;
	static boolean[][] map;
	static int[][] delta = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new boolean[N][M];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			map[r][c] = true;
		}

		int max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j]) {
					int size = dfs(i, j, 1);
					max = Math.max(max, size);
				}
			}
		}

		System.out.println(max);
	}

	static int dfs(int r, int c, int sum) {
		map[r][c] = false;

		for (int i = 0; i < delta.length; i++) {
			int nr = r + delta[i][0];
			int nc = c + delta[i][1];

			if (0 <= nr && nr < N && 0 <= nc && nc < M && map[nr][nc]) {
				sum = dfs(nr, nc, sum+1);
			}
		}
		return sum;
	}
}