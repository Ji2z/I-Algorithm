import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
* @since 2021. 4. 3.
* @author Jin
* @see https://www.acmicpc.net/problem/2665
* @mem 13648kb
* @time 104ms
* @caution G4
*/

public class 2665_미로만들기 {

	static int N;
	static int[][] map;
	static int[][] visited;
	static int[][] deltas = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		visited = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(s.charAt(j)+"");
				visited[i][j] = Integer.MAX_VALUE;
			}
		}

		bfs(0, 0);
		
		System.out.println(visited[N-1][N-1]);

	}

	static void bfs(int r, int c) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { r, c});
		visited[r][c] = 0;

		while (!queue.isEmpty()) {
			int qsize = queue.size();
			for (int i = 0; i < qsize; i++) {
				int[] x = queue.poll();
				
				for (int j = 0; j < 4; j++) {
					int nr = x[0] + deltas[j][0];
					int nc = x[1] + deltas[j][1];

					if (isIn(nr, nc) && visited[x[0]][x[1]] < visited[nr][nc]) {
						if (map[nr][nc] == 0) {
							visited[nr][nc] = visited[x[0]][x[1]] + 1;
							queue.add(new int[] { nr, nc});
						}else {
							visited[nr][nc] = visited[x[0]][x[1]];
							queue.add(new int[] { nr, nc});
						}
					}
				}
			}
		}
	}

	static boolean isIn(int nr, int nc) {
		return (0 <= nr && nr < N && 0 <= nc && nc < N);
	}

}