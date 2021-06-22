import java.io.*;
import java.util.*;

/**
* @since 2021. 6. 22.
* @author Jin
* @see https://www.acmicpc.net/problem/16988
* @mem 259736kb
* @time 548ms
* @caution S3
*/

public class BOJ_16988_Baaaaaaaaaduk2_Easy {

	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static int[][] deltas = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringBuilder output = new StringBuilder("");
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int answer = 0;
		for (int i1 = 0; i1 < N; i1++) {
			for (int j1 = 0; j1 < M; j1++) {
				if(map[i1][j1] != 0) continue;
				for (int i2 = j1 == M-1 ? i1 + 1 : i1; i2 < N; i2++) {
					for (int j2 = i1 == i2 ? j1 + 1 : 0; j2 < M; j2++) {
						
						if (map[i1][j1] == 0 && map[i2][j2] == 0) {
							int cnt = 0;
							visited = new boolean[N][M];
							int[][] temp = copy(map);
							temp[i1][j1] = 1;
							temp[i2][j2] = 1;

							for (int i = 0; i < N; i++) {
								for (int j = 0; j < M; j++) {
									if (temp[i][j] == 2 && !visited[i][j]) {
										cnt += bfs(i, j, temp);
									}
								}
							}

							answer = Math.max(answer, cnt);
						}
					}
				}
			}
		}

		System.out.println(answer);

	}

	static int bfs(int r, int c, int[][] cmap) {
		Queue<int[]> queue = new LinkedList<>();
		visited[r][c] = true;
		queue.add(new int[] { r, c });

		int cnt = 1;
		boolean flag = false;
		while (!queue.isEmpty()) {
			int[] temp = queue.poll();
			for (int d = 0; d < deltas.length; d++) {
				int nr = temp[0] + deltas[d][0];
				int nc = temp[1] + deltas[d][1];

				if (isIn(nr, nc)) {
					if (cmap[nr][nc] == 2 && !visited[nr][nc]) {
						queue.add(new int[] { nr, nc });
						visited[nr][nc] = true;
						cnt++;
					} else if (cmap[nr][nc] == 0) {
						flag = true;
					}
				}
			}
		}
		return flag ? 0 : cnt;
	}

	static int[][] copy(int[][] origin) {
		int[][] result = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				result[i][j] = origin[i][j];
			}
		}
		return result;
	}

	static boolean isIn(int nr, int nc) {
		return 0 <= nr && nr < N && 0 <= nc && nc < M;
	}
}
