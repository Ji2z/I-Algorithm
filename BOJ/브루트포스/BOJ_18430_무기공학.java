import java.io.*;
import java.util.*;

/**
* @since 2021. 6. 22.
* @author Jin
* @see https://www.acmicpc.net/problem/18430
* @mem 299028kb
* @time 2744ms
* @caution S1 - 완전탐색 이용, 백트래킹 가능
*/

public class BOJ_18430_무기공학 {

	static int N, M;
	static int[][] map;
	static int answer;
	static int[][][] deltas = { { { 0, -1 }, { 1, 0 } }, { { -1, 0 }, { 0, -1 } }, { { -1, 0 }, { 0, 1 } },
			{ { 1, 0 }, { 0, 1 } } };
	static int[][][] power;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder("");
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		answer = 0;
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		power = new int[N][M][4];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				getPower(i, j);
			}
		}

		boomerang(0, new boolean[N][M], new int[] { 0, 0 });

		System.out.println(answer);

	}

	static void getPower(int r, int c) {
		for (int d = 0; d < deltas.length; d++) {
			int tempS = map[r][c] * 2;

			int nr1 = r + deltas[d][0][0];
			int nc1 = c + deltas[d][0][1];
			int nr2 = r + deltas[d][1][0];
			int nc2 = c + deltas[d][1][1];

			if (isIn(nr1, nc1) && isIn(nr2, nc2)) {
				tempS += map[nr1][nc1];
				tempS += map[nr2][nc2];
				power[r][c][d] = tempS;
			}

		}
	}

	static void boomerang(int sum, boolean[][] visited, int[] pos) {
		if (sum > answer) {
			answer = sum;
		}

		int m = 0, n = 0;
		if (!(pos[0] == N - 1 && pos[1] == M - 1)) {
			if (pos[1] + 1 == M) {
				n = pos[0] + 1;
				m = 0;
			} else {
				n = pos[0];
				m = pos[1] + 1;
			}
			boomerang(sum + 0, copy(visited), new int[] { n, m });
		}

		if (!visited[pos[0]][pos[1]]) {
			for (int d = 0; d < deltas.length; d++) {
				if (power[pos[0]][pos[1]][d] != 0) {
					int nr1 = pos[0] + deltas[d][0][0];
					int nc1 = pos[1] + deltas[d][0][1];
					int nr2 = pos[0] + deltas[d][1][0];
					int nc2 = pos[1] + deltas[d][1][1];

					if (!visited[nr1][nc1] && !visited[nr2][nc2]) {
						visited[pos[0]][pos[1]] = true;
						visited[nr1][nc1] = true;
						visited[nr2][nc2] = true;
						boomerang(sum + power[pos[0]][pos[1]][d], copy(visited), new int[] { n, m });
						visited[nr1][nc1] = false;
						visited[nr2][nc2] = false;
					}
				}
			}
		}
	}

	static boolean[][] copy(boolean[][] origin) {
		boolean[][] result = new boolean[N][M];
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
