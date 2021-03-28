import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @since 2021. 3. 28.
 * @author Jin
 * @see https://www.acmicpc.net/problem/5427
 * @mem 116240kb
 * @time 612ms
 * @caution G4 - 전역변수 초기화를 꼭 해주자...
 */

public class 5427_불 {

	static int T, N, M;
	static char[][] map;
	static int[][] deltas = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	static boolean[][] visited;
	static Queue<int[]> fire = new LinkedList<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder output = new StringBuilder("");

		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			M = Integer.parseInt(st.nextToken()); // 가로
			N = Integer.parseInt(st.nextToken()); // 세로

			int sr = -1;
			int sc = -1;
			map = new char[N][M];
			visited = new boolean[N][M];
			fire = new LinkedList<>();
			for (int i = 0; i < N; i++) {
				String s = br.readLine();
				for (int j = 0; j < M; j++) {
					char c = s.charAt(j);
					map[i][j] = c;
					if (c == '*') {
						fire.add(new int[] { i, j });
						visited[i][j] = true;
					} else if (c == '#')
						visited[i][j] = true;
					else if (c == '@') {
						sr = i;
						sc = j;
					}
				}
			}

			int result = bfs(sr, sc);
			//System.out.println(result);
			if (result == -1)
				output.append("IMPOSSIBLE\n");
			else
				output.append(result).append("\n");
		}
		System.out.println(output);
	}

	static int bfs(int r, int c) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { r, c });
		visited[r][c] = true;

		int cnt = 0;
		while (!queue.isEmpty()) {
			cnt++;
			
			// 불
			int fsize = fire.size();
			for (int s = 0; s < fsize; s++) {
				int[] curr = fire.poll();
				
				for (int i = 0; i < 4; i++) {
					int nr = curr[0] + deltas[i][0];
					int nc = curr[1] + deltas[i][1];
					
					if (isIn(nr, nc) && !visited[nr][nc]) {
						fire.offer(new int[] { nr, nc });
						visited[nr][nc] = true;
					}
				}
			}
			
			// 상근이
			int size = queue.size();
			for (int s = 0; s < size; s++) {
				int[] curr = queue.poll();

				if (curr[0] == 0 || curr[0] == N - 1 || curr[1] == 0 || curr[1] == M - 1)
					return cnt;
				
				for (int i = 0; i < 4; i++) {
					int nr = curr[0] + deltas[i][0];
					int nc = curr[1] + deltas[i][1];
					if (isIn(nr, nc) && !visited[nr][nc] && map[nr][nc]=='.') {
						//System.out.println(nr+", "+nc+", "+cnt);
						queue.offer(new int[] { nr, nc });
						//map[curr[0]][curr[1]] = '.';
						map[nr][nc] = '@';
					}
				}
			}

		}
		return -1;
	}

	static boolean isIn(int nr, int nc) {
		return (0 <= nr && nr < N && 0 <= nc && nc < M);
	}
}