import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @since 2021. 3. 17.
 * @author Jin
 * @see https://www.acmicpc.net/problem/3184
 * @mem 17936kb
 * @time 172ms
 * @caution S2
 */

public class 3184_양 {

	static int R, C;
	static char[][] map;
	static boolean[][] visited;
	static List<int[]> wolf;
	static int[][] delta = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		visited = new boolean[R][C];
		wolf = new ArrayList<>();

		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				char c = s.charAt(j);
				map[i][j] = c;
				if (c == 'v') {
					wolf.add(new int[] { i, j });
				} else if (c == '#') {
					visited[i][j] = true;
				}
			}
		}

		int sh = 0;
		int wo = 0;
		for (int i = 0; i < wolf.size(); i++) {
			if (!visited[wolf.get(i)[0]][wolf.get(i)[1]]) {
				int[] result = bfs(wolf.get(i)[0], wolf.get(i)[1]);
				sh += result[0];
				wo += result[1];
			}
		}
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j] == 'o')
					sh++;
			}
		}

		System.out.println(String.format("%d %d", sh, wo));
	}

	static int[] bfs(int r, int c) { // return : 양 , 늑대 수
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { r, c });
		visited[r][c] = true;

		int sheep = 0;
		int wolf = 1;
		while (!queue.isEmpty()) {
			int[] curr = queue.poll();
			int x = curr[0];
			int y = curr[1];
			for (int i = 0; i < 4; i++) {
				int nr = x + delta[i][0];
				int nc = y + delta[i][1];

				if (0 <= nr && nr < R && 0 <= nc && nc < C && !visited[nr][nc]) {
					if (map[nr][nc] == 'o') {
						map[nr][nc] = '.';
						sheep++;
					}
					else if (map[nr][nc] == 'v') {
						map[nr][nc] = '.';
						wolf++;
					}
					visited[nr][nc] = true;
					queue.offer(new int[] { nr, nc });
				}
			}
		}

		if (sheep <= wolf)
			sheep = 0;
		else
			wolf = 0;

		return new int[] { sheep, wolf };
	}
}