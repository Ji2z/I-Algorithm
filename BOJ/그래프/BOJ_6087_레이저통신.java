import java.io.*;
import java.util.*;

/**
 * @since 2021. 5. 15.
 * @author Jin
 * @see https://www.acmicpc.net/problem/6087
 * @mem 12720kb
 * @time 112ms
 * @caution G4 - PQ이용
 */
public class BOJ_6087_레이저통신 {

	static int W, H, answer;
	static char[][] map;
	static int[][] visited;
	static int[][] deltas = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static Info C1, C2;

	static class Info implements Comparable<Info> {
		int x;
		int y;
		int d;
		int sum;

		public Info(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		public Info(int x, int y, int d, int sum) {
			super();
			this.x = x;
			this.y = y;
			this.d = d;
			this.sum = sum;
		}

		@Override
		public String toString() {
			return "Info [x=" + x + ", y=" + y + ", d=" + d + ", sum=" + sum + "]";
		}

		@Override
		public int compareTo(Info o) {
			return Integer.compare(sum, o.sum);
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringBuilder output = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		map = new char[H][W];
		visited = new int[H][W];
		for (int i = 0; i < H; i++) {
			String s = br.readLine();
			for (int j = 0; j < W; j++) {
				map[i][j] = s.charAt(j);
				if (map[i][j] == 'C') {
					if (C1 == null)
						C1 = new Info(i, j);
					else
						C2 = new Info(i, j);
				}
			}
		}

		for (int i = 0; i < H; i++) {
			Arrays.fill(visited[i], H*W);
		}

		System.out.println(bfs(C1.x, C1.y));
	}

	static int bfs(int r, int c) {
		PriorityQueue<Info> queue = new PriorityQueue<>();
		queue.add(new Info(r, c, -1, 0));
		visited[r][c] = 0;
		while (!queue.isEmpty()) {
			Info info = queue.poll();
			//System.out.println(info.toString());

			if (info.x == C2.x && info.y == C2.y)
				return info.sum;

			for (int d = 0; d < 4; d++) {
				int nr = info.x + deltas[d][0];
				int nc = info.y + deltas[d][1];

				int sum = 0;
				if (info.d == -1 || info.d == d)
					sum = info.sum;
				else
					sum = info.sum + 1;
				
				if (isIn(nr, nc) && sum <= visited[nr][nc] && map[nr][nc] != '*') {
					
					queue.add(new Info(nr, nc, d, sum));
					visited[nr][nc] = sum;

				}
			}
		}
		return -1;
	}

	static boolean isIn(int nr, int nc) {
		return 0 <= nr && nr < H && 0 <= nc && nc < W;
	}

}
