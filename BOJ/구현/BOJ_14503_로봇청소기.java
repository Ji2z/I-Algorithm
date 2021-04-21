import java.io.*;
import java.util.*;

/**
* @since 2021. 4. 21.
* @author Jin
* @see https://www.acmicpc.net/problem/14503
* @mem 11840kb
* @time 140ms
* @caution G5
*/

public class BOJ_14503_로봇청소기 {

	static int N, M, answer, zero;
	static int map[][];
	static boolean visited[][];
	static int[][] deltas = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } }; // 북, 동, 남, 서

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringBuilder output = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];

		st = new StringTokenizer(br.readLine(), " ");
		int starti = Integer.parseInt(st.nextToken());
		int startj = Integer.parseInt(st.nextToken());
		int startd = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1)
					visited[i][j] = true;
			}
		}

		boolean go = true;
		int rotate = 0;
		while (true) {
			//System.out.println(starti+", "+startj+", "+startd+", "+rotate);
			if (go) {
				// 1. 현재 위치 청소
				visited[starti][startj] = true;
				go = false;
				answer++;
			}

			// 2-1. 왼쪽방향에 청소 안함 -> 1
			int nr = starti + deltas[startd == 0 ? 3 : (startd - 1)][0];
			int nc = startj + deltas[startd == 0 ? 3 : (startd - 1)][1];

			if (isIn(nr, nc) && !visited[nr][nc]) {
				starti = nr;
				startj = nc;
				startd = startd == 0 ? 3 : (startd - 1);
				go = true;
				rotate = 0;
				continue;
			}

			// 2-2. 왼쪽방향에 공간 없음 -> 왼쪽으로 방향 회전 후 2-1
			else {
				rotate++;
				startd = startd == 0 ? 3 : (startd - 1);
				if (rotate < 4)
					continue;
			}

			rotate = 0;
			// 2-3. 모든 방향 청소완료거나 벽 -> 한칸 후진 후 2-1

			nr = starti - deltas[startd][0];
			nc = startj - deltas[startd][1];

			if (isIn(nr, nc)&&map[nr][nc]==0) {
				starti = nr;
				startj = nc;
				continue;
			}

			// 2-4. 2-3에서 한 칸 후진이 벽 -> 멈춤
			else
				break;
		}

		System.out.println(answer);
	}

	static boolean isIn(int nr, int nc) {
		return 0 <= nr && nr < N && 0 <= nc && nc < M;
	}
}
