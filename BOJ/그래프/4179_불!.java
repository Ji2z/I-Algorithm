import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @since 2021. 3. 28.
 * @author Jin
 * @see https://www.acmicpc.net/problem/4179
 * @mem 68852kb
 * @time 540ms
 * @caution G4 - 5427번과 동일
 */

public class 4179_불! {

	static int R, C;
	static char[][] map;
	static int[][] deltas = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	static boolean[][] visited;
	static Queue<int[]> fire = new LinkedList<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken()); // 행
		C = Integer.parseInt(st.nextToken()); // 열

		int sr = -1;
		int sc = -1;
		map = new char[R][C];
		visited = new boolean[R][C];
		fire = new LinkedList<>();
		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				char c = s.charAt(j);
				map[i][j] = c;
				if (c == 'F') {
					fire.add(new int[] { i, j });
					visited[i][j] = true;
				} else if (c == '#')
					visited[i][j] = true;
				else if (c == 'J') {
					sr = i;
					sc = j;
				}
			}
		}

		int result = bfs(sr, sc);
		// System.out.println(result);
		if (result == -1)
			System.out.println("IMPOSSIBLE");
		else
			System.out.println(result);

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

				if (curr[0] == 0 || curr[0] == R - 1 || curr[1] == 0 || curr[1] == C - 1)
					return cnt;

				for (int i = 0; i < 4; i++) {
					int nr = curr[0] + deltas[i][0];
					int nc = curr[1] + deltas[i][1];
					if (isIn(nr, nc) && !visited[nr][nc] && map[nr][nc] == '.') {
						queue.offer(new int[] { nr, nc });
						map[nr][nc] = 'J';
					}
				}
			}

		}
		return -1;
	}

	static boolean isIn(int nr, int nc) {
		return (0 <= nr && nr < R && 0 <= nc && nc < C);
	}
}