import java.io.*;
import java.util.*;

/**
* @since 2021. 4. 21.
* @author Jin
* @see https://www.acmicpc.net/problem/15685
* @mem 12212kb
* @time 96kb
* @caution G4 패턴찾기, 삼성 기출
*/

public class BOJ_15685_드래곤커브 {

	static int N, X, Y;
	static boolean map[][];
	static int[][] deltas = { { 1, 0 }, { 0, -1 }, { -1, 0 }, { 0, 1 } };

	static class Curve {
		int x;
		int y;
		int dir;
		int gen;

		public Curve(int x, int y, int dir, int gen) {
			super();
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.gen = gen;
		}

		@Override
		public String toString() {
			return "Curve [x=" + x + ", y=" + y + ", dir=" + dir + ", gen=" + gen + " ]";
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringBuilder output = new StringBuilder();
		StringTokenizer st = null;

		N = Integer.parseInt(br.readLine());
		map = new boolean[101][101];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			// 시작점
			X = Integer.parseInt(st.nextToken());
			Y = Integer.parseInt(st.nextToken());
			// 시작 방향 : 오 위 왼 아
			int d = Integer.parseInt(st.nextToken());
			// 세대
			int g = Integer.parseInt(st.nextToken());

			makeCurve(i, X, Y, d, g);
		}

		int answer = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (map[i][j] && map[i][j + 1] && map[i + 1][j] && map[i + 1][j + 1])
					answer++;
			}
		}

		System.out.println(answer);
	}

	static void makeCurve(int i, int x, int y, int d, int g) {
		List<Curve> list = new ArrayList<>();
		
		list.add(new Curve(x+deltas[d][0], y+deltas[d][1], d, 0));
		map[x][y] = true;
		map[x+deltas[d][0]][y+deltas[d][1]] = true;
		
		int size;
		int gen = 0;
		while (true) {
			if (list.get(list.size() - 1).gen >= g)
				break;
			gen++;
			size = list.size();
			for (int j = 0; j < size; j++) {
				Curve c = list.get(size - 1 - j);
				Curve last = list.get(list.size()-1);
				int di = (c.dir+1) % 4;
				Curve move = new Curve(last.x + deltas[di][0], last.y + deltas[di][1], di, gen);
				list.add(move);
				map[move.x][move.y] = true;
			}
		}
	}

}
