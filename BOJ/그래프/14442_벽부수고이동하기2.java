import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @since 2021. 3. 28.
 * @author Jin
 * @see https://www.acmicpc.net/problem/14442
 * @mem 374456kb
 * @time 1684ms
 * @caution G3 - 1600번 말이 되고픈 원숭이와 비슷. / 2206번 벽 부수고 이동하기 다음단계.
 */

public class 14442_벽부수고이동하기2 {

	static int N, M, K;
	static int[][] map;
	static int[][] deltas = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	static boolean[][][] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 행
		M = Integer.parseInt(st.nextToken()); // 열
		K = Integer.parseInt(st.nextToken()); // 벽 부술수 있는 횟수

		map = new int[N][M];
		visited = new boolean[N][M][K+1];

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(s.charAt(j)+"");
			}
		}

		int result = bfs(0, 0);

		System.out.println(result);

	}

	static int bfs(int r, int c) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { r, c, 0 });
		visited[r][c][0] = true;

		int cnt = 0;
		while (!queue.isEmpty()) {
			cnt++;
			int size = queue.size();
			for (int s = 0; s < size; s++) {
				int[] curr = queue.poll();
				//System.out.println(curr[0]+", "+curr[1]+", "+curr[2]+", "+cnt);
				if (curr[0] == N - 1 && curr[1] == M - 1)
					return cnt;

				for (int i = 0; i < 4; i++) {
					int nr = curr[0] + deltas[i][0];
					int nc = curr[1] + deltas[i][1];
					if (isIn(nr, nc) && !visited[nr][nc][curr[2]] && map[nr][nc] == 0) {
						queue.offer(new int[] { nr, nc, curr[2]});
						visited[nr][nc][curr[2]] = true;
					}
				}
				
				if(curr[2]<K) {
					for (int i = 0; i < 4; i++) {
						int nr = curr[0] + deltas[i][0];
						int nc = curr[1] + deltas[i][1];
						if (isIn(nr, nc) && !visited[nr][nc][curr[2]+1] && map[nr][nc] == 1) {
							queue.offer(new int[] { nr, nc, curr[2]+1});
							visited[nr][nc][curr[2]+1] = true;
						}
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