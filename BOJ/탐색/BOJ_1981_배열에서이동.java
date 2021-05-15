import java.io.*;
import java.util.*;

/**
* @since 2021. 5. 15.
* @author Jin
* @see https://www.acmicpc.net/problem/1981
* @mem 73428kb
* @time 332ms
* @caution G1 - 이분탐색 + 투포인터 + bfs
*/
public class BOJ_1981_배열에서이동 {

	static int N, answer;
	static int[][] map;
	static boolean[][] visited;
	static int[][] deltas = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	static class Info {
		int x;
		int y;

		public Info(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Info [x=" + x + ", y=" + y + "]";
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringBuilder output = new StringBuilder();
		StringTokenizer st = null;

		N = Integer.parseInt(br.readLine());

		int max = -1;
		int min = 201;
		map = new int[N][N];
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, map[i][j]);
				min = Math.min(min, map[i][j]);
			}
		}

		int start = Math.abs(map[0][0] - map[N - 1][N - 1]);
		int end = max - min;
		int answer = 201;
		while (start <= end) {
			int mid = (start + end) / 2;
			// System.out.println(mid);
			boolean flag = false;
			for (int s = min; s <= (max - mid); s++) {
				if (map[0][0] < s || map[0][0] > (s + mid))
					continue;
				flag = bfs(s, s + mid);
				if (flag)
					break;
			}
			if (flag) {
				end = mid - 1;
				answer = mid;
			} else {
				start = mid + 1;
			}
		}

		System.out.println(answer);
	}

	static boolean bfs(int s, int e) {
		visited = new boolean[N][N];
		Queue<Info> queue = new LinkedList<>();
		queue.add(new Info(0, 0));
		visited[0][0] = true;
		while (!queue.isEmpty()) {
			Info info = queue.poll();
			//System.out.println(info.toString());

			if (info.x == N - 1 && info.y == N - 1)
				return true;

			for (int d = 0; d < 4; d++) {
				int nr = info.x + deltas[d][0];
				int nc = info.y + deltas[d][1];
				if (isIn(nr, nc) && !visited[nr][nc] && map[nr][nc] >= s && map[nr][nc] <= e) {
					queue.add(new Info(nr, nc));
					visited[nr][nc] = true;
				}
			}
		}
		return false;
	}

	static boolean isIn(int nr, int nc) {
		return 0 <= nr && nr < N && 0 <= nc && nc < N;
	}

}
