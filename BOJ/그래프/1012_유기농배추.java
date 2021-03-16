import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @since 2021. 3. 16.
 * @author Jin
 * @see https://www.acmicpc.net/problem/1012
 * @mem 13300kb
 * @time 120ms
 * @caution S2 dfs
 */

public class 1012_유기농배추 {

	static boolean[][] map;
	static int[][] delta = {{-1,0},{1,0},{0,-1},{0,1}};
	static int M, N, cnt = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder("");
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			map = new boolean[N][M];
			cnt = 0;

			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int c = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				map[r][c] = true;
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(map[i][j]) {
						cnt++;
						check(i, j);
					}
				}
			}
			
			output.append(cnt).append("\n");
		}
		
		System.out.println(output);
	}

	static void check(int r, int c) {
		if (!map[r][c])
			return;
		map[r][c] = false;
		for (int i = 0; i < delta.length; i++) {
			int nr = r+delta[i][0];
			int nc = c+delta[i][1];
			
			if(0<=nr && nr<N && 0<=nc && nc<M && map[nr][nc]) {
				check(nr,nc);
			}
		}
	}

}