import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @since 2021. 3. 19.
 * @author Jin
 * @see https://www.acmicpc.net/problem/2589
 * @mem 293116kb
 * @time 480ms
 * @caution G5
 */

public class 2589_보물섬 {

	static int N, M;
	static boolean[][] visited;
	static char[][] map;
	static int[][] delta = {{-1,0},{1,0},{0,-1},{0,1}};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder("");
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		visited = new boolean[N][M];
		map = new char[N][M];

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		
		int max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				visited = new boolean[N][M];
				if(map[i][j]=='L'&&!visited[i][j]) {
					int depth = bfs(i, j);
					max = Math.max(max, depth);
				}
			}
		}
		
		System.out.println(max);
	}

	static int bfs(int r, int c) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {r,c});
		visited[r][c] = true;
		
		int depth = -1;
		while(!queue.isEmpty()) {
			int qsize = queue.size();
			for (int s = 0; s < qsize; s++) {
				int[] x = queue.poll();
				for (int i = 0; i < 4; i++) {
					int nr = x[0] + delta[i][0];
					int nc = x[1] + delta[i][1];
					
					if(0<=nr&&nr<N&&0<=nc&&nc<M&&!visited[nr][nc]&&map[nr][nc]=='L') {
						queue.offer(new int[] {nr, nc});
						visited[nr][nc] = true;
					}
				}		
			}
			depth++;
		}
		
		return depth;
	}
}