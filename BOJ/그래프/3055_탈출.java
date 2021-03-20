import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @since 2021. 3. 20.
 * @author Jin
 * @see https://www.acmicpc.net/problem/3055
 * @mem 11864kb
 * @time 84ms
 * @caution G5
 */

public class 3055_탈출 {

	static int N, M, wr, wc, sr, sc, dr, dc;
	static boolean[][] visited;
	static char[][] map;
	static int[][] delta = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder("");
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		visited = new boolean[N][M];
		map = new char[N][M];

		Queue<int[]> queue = new LinkedList<>();
		Queue<int[]> dochi = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				char c = s.charAt(j);
				map[i][j] = c;
				if (c == '*') {
					wr = i;
					wc = j;
					queue.offer(new int[] { i, j });
					visited[i][j] = true;
				} else if (c == 'S') {
					sr = i;
					sc = j;
					dochi.offer(new int[] { i, j });
				} else if (c == 'D') {
					dr = i;
					dc = j;
				} else if (c == 'X') {
					visited[i][j] = true;
				}
			}
		}
		
		int answer = bfs(queue, dochi);

		System.out.println(answer);
	}

	static int bfs(Queue<int[]> queue, Queue<int[]> dochi) {

		int depth = 0;
		while (!queue.isEmpty()||!dochi.isEmpty()) {
			int qsize = queue.size();
			int dosize = dochi.size();
			for (int s = 0; s < qsize; s++) {
				int[] x = queue.poll();
				for (int i = 0; i < 4; i++) {
					int nr = x[0] + delta[i][0];
					int nc = x[1] + delta[i][1];

					if (0 <= nr && nr < N && 0 <= nc && nc < M && !visited[nr][nc] && map[nr][nc] != 'X' && map[nr][nc] != 'D') {
						queue.offer(new int[] { nr, nc });
						visited[nr][nc] = true;
						map[nr][nc] = '*';
					}
				}
			}
			for (int s = 0; s < dosize; s++) {
				int[] x = dochi.poll();
				for (int i = 0; i < 4; i++) {
					int nr = x[0] + delta[i][0];
					int nc = x[1] + delta[i][1];
					
					if(nr == dr && nc == dc)
						return depth+1;
					if (0 <= nr && nr < N && 0 <= nc && nc < M && map[nr][nc] == '.') {
						//System.out.println(nr+", "+nc);
						dochi.offer(new int[] { nr, nc });
						map[nr][nc] = 'S';
					}
				}
			}
			//System.out.println(dochi.size());
			if(dochi.size()==0) {
				System.out.println("KAKTUS");
				System.exit(0);
			}
			depth++;
		}

		return depth;
	}

	
}