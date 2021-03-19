import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @since 2021. 3. 19.
 * @author Jin
 * @see https://www.acmicpc.net/problem/10026
 * @mem 12548kb
 * @time 96ms
 * @caution G5
 */

public class 10026_적록색약 {

	static int N;
	static char[][] map;
	static boolean[][] visited;
	static int[][] delta = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder("");

		N = Integer.parseInt(br.readLine());

		map = new char[N][N];
		
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = s.charAt(j);
			}
		}

		int cnt = 0;
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					dfs(i, j);
					cnt++;
				}
			}
		}		
		output.append(cnt).append(" ");
		
		cnt = 0;
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					dfs2(i, j);
					cnt++;
				}
			}
		}
		output.append(cnt).append(" ");
		
		System.out.println(output);
	}

	static void dfs(int r, int c) {
		visited[r][c] = true;

		for (int i = 0; i < delta.length; i++) {
			int nr = r + delta[i][0];
			int nc = c + delta[i][1];

			if (0 <= nr && nr < N && 0 <= nc && nc < N && map[r][c] == map[nr][nc] && !visited[nr][nc]) {
				dfs(nr, nc);
			}
		}
	}
	
	static void dfs2(int r, int c) {
		visited[r][c] = true;

		for (int i = 0; i < delta.length; i++) {
			int nr = r + delta[i][0];
			int nc = c + delta[i][1];

			if (0 <= nr && nr < N && 0 <= nc && nc < N && !visited[nr][nc]) {
				if((map[r][c]=='R'&&map[nr][nc]=='G')||(map[r][c]=='G'&&map[nr][nc]=='R')||map[r][c] == map[nr][nc])
					dfs2(nr, nc);
			}
		}
	}
}