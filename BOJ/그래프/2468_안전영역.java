import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @since 2021. 3. 19.
 * @author Jin
 * @see https://www.acmicpc.net/problem/2468
 * @mem 16524kb
 * @time 232ms
 * @caution S1 아무 지역도 물에 잠기지 않는다는 것은 비가 안온다는 것..
 */

public class 2468_안전영역 {

	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int[][] delta = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int cnt = 0;
		int max = 0;
		for (int k = 0; k <= 100; k++) {
			visited = new boolean[N][N];
			cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(!visited[i][j] && map[i][j]>k) {
						dfs(i, j, k);
						cnt++;
					}
				}
			}
			max = Math.max(max, cnt);
			if(cnt == 0)
				break;
		}

		System.out.println(max);
	}

	static void dfs(int r, int c, int rain) {
		visited[r][c] = true;

		for (int i = 0; i < delta.length; i++) {
			int nr = r + delta[i][0];
			int nc = c + delta[i][1];
			
			if(0<=nr&&nr<N&&0<=nc&&nc<N&&!visited[nr][nc]&&map[nr][nc]>rain) {
				dfs(nr, nc, rain);
			}
		}
		
	}
}