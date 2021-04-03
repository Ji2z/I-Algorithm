import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
* @since 2021. 4. 3.
* @author Jin
* @see https://www.acmicpc.net/problem/2638
* @mem 43580kb
* @time 336ms
* @caution
*/

public class 2638_치즈 {

	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static int[][] deltas = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int cheese;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder("");
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visited = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				int a = Integer.parseInt(st.nextToken());
				map[i][j] = a;
				if(a==1)
					cheese++;
			}
		}

		int answer = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(!visited[i][j] && map[i][j] == 0 && cheese > 0) {
					bfs(i, j);
					answer++;
					visited = new boolean[N][M];
					i=0;
					j=-1;
				}
			}
		}
		
		System.out.println(answer);

	}

	static void bfs(int r, int c) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { r, c });
		visited[r][c] = true;

		List<int[]> list = new ArrayList<>();
		while (!queue.isEmpty()) {
			int qsize = queue.size();
			for (int i = 0; i < qsize; i++) {
				int[] x = queue.poll();

				for (int j = 0; j < 4; j++) {
					int nr = x[0] + deltas[j][0];
					int nc = x[1] + deltas[j][1];

					if (isIn(nr, nc) && !visited[nr][nc]) {
						if (map[nr][nc] == 0) {
							queue.add(new int[] { nr, nc });
							visited[nr][nc] = true;
						}else {
							list.add(new int[] {nr,nc});
							visited[nr][nc] = true;
						}
					}
				}
			}
		}
		
		List<int[]> remove = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			int air = 0;
			int[] x = list.get(i);
			
			for (int d = 0; d < 4; d++) {
				int nr2 = x[0] + deltas[d][0];
				int nc2 = x[1] + deltas[d][1];
				
				if(isIn(nr2, nc2) && map[nr2][nc2]==0 && visited[nr2][nc2]) {
					air++;
				}
			}
			if(air>=2) {
				remove.add(list.get(i));
			}
		}
		
		for (int i = 0; i < remove.size(); i++) {
			int[] temp = remove.get(i);
			map[temp[0]][temp[1]] = 0;
			cheese--;
		}
	}

	static boolean isIn(int nr, int nc) {
		return (0 <= nr && nr < N && 0 <= nc && nc < M);
	}

}