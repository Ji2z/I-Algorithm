import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @since 2021. 3. 28.
 * @author Jin
 * @see https://www.acmicpc.net/problem/1726
 * @mem 12569kb
 * @time 96ms
 * @caution G4 - 동서남북으로 방문체크를 다 해주고, 벽이 아닌 이상 1,2,3칸을 다 가본다. (중간에 방문한 곳이 있더라도)
 */

public class 1726_로봇 {

	static int N, M, destR, destC, destD;
	static int[][] map;
	static int[][] deltas = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } }; // 동 서 남 북
	static boolean[][][] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		M = Integer.parseInt(st.nextToken()); // 세로
		N = Integer.parseInt(st.nextToken()); // 가로

		map = new int[M][N];
		visited = new boolean[M][N][4]; // 동서남북 방문체크
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine(), " ");
		int robotR = Integer.parseInt(st.nextToken()) - 1;
		int robotC = Integer.parseInt(st.nextToken()) - 1;
		int robotD = Integer.parseInt(st.nextToken()) - 1;

		st = new StringTokenizer(br.readLine(), " ");
		destR = Integer.parseInt(st.nextToken()) - 1;
		destC = Integer.parseInt(st.nextToken()) - 1;
		destD = Integer.parseInt(st.nextToken()) - 1;

		System.out.println(bfs(robotR, robotC, robotD));

	}

	static int bfs(int r, int c, int d) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { r, c, d });
		visited[r][c][d] = true;

		int cnt = -1;
		while (!queue.isEmpty()) {
			cnt++;
			int size = queue.size();
			for (int s = 0; s < size; s++) {
				int[] curr = queue.poll();
				//System.out.println(cnt + ", " + curr[0] + ", " + curr[1] + ", " + curr[2]);

				// 도착
				if (curr[0] == destR && curr[1] == destC && curr[2] == destD)
					return cnt;

				// 방문체크
				//visited[curr[0]][curr[1]][curr[2]] = true;

				// Turn
				if (curr[2] < 2) {// 동, 서 => 남, 북
					if (!visited[curr[0]][curr[1]][2]) {
						queue.offer(new int[] { curr[0], curr[1], 2 }); // 남
						visited[curr[0]][curr[1]][2] = true;
					}
					if (!visited[curr[0]][curr[1]][3]) {
						queue.offer(new int[] { curr[0], curr[1], 3 }); // 북
						visited[curr[0]][curr[1]][3] = true;
					}
				} else { // 남, 북 => 동, 서
					if (!visited[curr[0]][curr[1]][0]) {
						queue.offer(new int[] { curr[0], curr[1], 0 }); // 동
						visited[curr[0]][curr[1]][0] = true;
					}
					if (!visited[curr[0]][curr[1]][1]) {
						queue.offer(new int[] { curr[0], curr[1], 1 }); // 서
						visited[curr[0]][curr[1]][1] = true;
					}
				}

				// Go : 1 ~ 3칸을 움직인다.
				for (int i = 1; i <= 3; i++) {
					int nr = curr[0] + deltas[curr[2]][0] * i;
					int nc = curr[1] + deltas[curr[2]][1] * i;

					if (isIn(nr, nc)) {
						if (map[nr][nc] == 0) {
							if (!visited[nr][nc][curr[2]]) {
								queue.offer(new int[] { nr, nc, curr[2] });
								visited[nr][nc][curr[2]] = true;
							}
						} else
							break;
					} else break;
				}

			}
		}
		return -1;
	}

	static boolean isIn(int nr, int nc) {
		return (0 <= nr && nr < M && 0 <= nc && nc < N);
	}
}