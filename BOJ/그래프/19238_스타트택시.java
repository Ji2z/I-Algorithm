import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @since 2021. 3. 21.
 * @author Jin
 * @see https://www.acmicpc.net/problem/19238
 * @mem 18528kb
 * @time 160ms
 * @caution G4
 */

public class 19238_스타트택시 {

	static int N, M, Fuel, tr, tc, num;
	static boolean[][] visited;
	static int[][] map;
	static Pass[][] passMap;
	static int[][] delta = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	static class Pass implements Comparable<Pass> {
		int sr;
		int sc;
		int dr;
		int dc;

		public Pass(int sr, int sc, int dr, int dc) {
			super();
			this.sr = sr;
			this.sc = sc;
			this.dr = dr;
			this.dc = dc;
		}

		@Override
		public int compareTo(Pass o) {
			int diff = Integer.compare(this.sr, o.sr);
			if (diff == 0)
				diff = Integer.compare(this.sc, o.sc);
			return diff;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		Fuel = Integer.parseInt(st.nextToken());

		visited = new boolean[N][N];
		map = new int[N][N];
		passMap = new Pass[N][N];
		num = M; // 남은 승객 수

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				int a = Integer.parseInt(st.nextToken());
				map[i][j] = a;
				if (a == 1)
					visited[i][j] = true;
			}
		}

		// 초기 택시 위치
		st = new StringTokenizer(br.readLine(), " ");
		tr = Integer.parseInt(st.nextToken()) - 1;
		tc = Integer.parseInt(st.nextToken()) - 1;

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int sr = Integer.parseInt(st.nextToken()) - 1;
			int sc = Integer.parseInt(st.nextToken()) - 1;
			int dr = Integer.parseInt(st.nextToken()) - 1;
			int dc = Integer.parseInt(st.nextToken()) - 1;

			passMap[sr][sc] = new Pass(sr, sc, dr, dc);
		}

		// 택시에서 가장 가까운 승객 탐색 => 도착지까지 가서 연료 계산
		while (num > 0) {
			taxi(tr, tc, copy(visited));
		}

		System.out.println(Fuel);
	}

	static boolean[][] copy(boolean[][] origin) {
		boolean[][] c = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				c[i][j] = origin[i][j];
			}
		}
		return c;
	}

	static int distance(int i, int j, boolean[][] check) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { i, j });
		check[i][j] = true;

		int depth = 0;
		while (!queue.isEmpty()) {
			int qsize = queue.size();
			for (int s = 0; s < qsize; s++) {
				int[] x = queue.poll();
				for (int d = 0; d < 4; d++) {
					int nr = x[0] + delta[d][0];
					int nc = x[1] + delta[d][1];

					if (nr == tr && nc == tc)
						return depth + 1;
					if (0 <= nr && nr < N && 0 <= nc && nc < N && !check[nr][nc]) {
						queue.offer(new int[] { nr, nc });
						check[nr][nc] = true;
					}
				}
			}
			depth++;
		}

		// while문 안에서 리턴이 안되면 갈 수 없는 지역
		System.out.println(-1);
		System.exit(0);
		return -1;
	}

	static void taxi(int i, int j, boolean[][] check) {
		PriorityQueue<Pass> pass = new PriorityQueue<>(); // 승객을 담을 우선순위 큐
		Queue<int[]> queue = new LinkedList<>(); // 탐색 위치를 담을 큐
		queue.offer(new int[] { i, j });
		check[i][j] = true; // 방문 체크 : 벽도 체크 되어있음

		// 택시와 승객이 같은 자리
		if (passMap[i][j] != null) {
			pass.offer(passMap[i][j]);
		}

		int depth = 0;
		while (!queue.isEmpty() && pass.isEmpty()) { // 탐색 위치가 남아있고, 승객은 없을 때까지
			int qsize = queue.size();
			for (int s = 0; s < qsize; s++) {
				int[] x = queue.poll();
				for (int d = 0; d < 4; d++) {
					int nr = x[0] + delta[d][0];
					int nc = x[1] + delta[d][1];

					if (0 <= nr && nr < N && 0 <= nc && nc < N && !check[nr][nc]) {
						queue.offer(new int[] { nr, nc });
						check[nr][nc] = true;
						if (passMap[nr][nc] != null) { // 만약 승객 위치면 depth까지의 승객 담기
							pass.offer(passMap[nr][nc]);
						}
					}
				} // 사방탐색 끝
			} // 큐 사이즈만큼 끝
			depth++;
		}

		// 승객은 남았는데 큐에 담긴 승객이 없을 경우
		if (num > 0 && pass.size() == 0) {
			System.out.println(-1);
			System.exit(0);
		}

		// 태울 승객 확정
		Pass p = pass.poll();
		passMap[p.sr][p.sc] = null; // 맵에서 승객 지움
		tr = p.dr;
		tc = p.dc;
		int dist = distance(p.sr, p.sc, copy(visited)); // 도착지점까지 거리
		num--;

		// 연료 계산
		Fuel -= (depth + dist);
		if (Fuel < 0) {
			System.out.println(-1);
			System.exit(0);
		}
		Fuel += (2 * dist);

		return;
	}

}